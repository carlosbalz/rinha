package com.rinha.rinha.api.controller;

import com.rinha.rinha.api.cache.PessoaCache;
import com.rinha.rinha.api.service.PessoaService;
import com.rinha.rinha.entity.Pessoa;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static Logger logger = LoggerFactory.getLogger(PessoaController.class);
    @Autowired
    private PessoaService service;

    @Autowired
    private PessoaCache pessoaCache;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Pessoa pessoa) {
        if(!pessoa.isValid() || pessoaCache.hasApelido(pessoa.getApelido())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        pessoa.setId(UUID.randomUUID());
        service.create(pessoa);
        pessoaCache.add(pessoa);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/pessoas/" + pessoa.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable UUID id) {
        Pessoa pessoa = pessoaCache.findById(id);
        if(pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findByTermo(@RequestParam("t") String t) {
        return ResponseEntity.ok(service.findByTermo(t));
    }

    @GetMapping("/contagem-pessoas")
    public long count() {
        return service.count();
    }
}
