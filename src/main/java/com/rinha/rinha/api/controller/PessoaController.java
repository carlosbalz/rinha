package com.rinha.rinha.api.controller;

import com.rinha.rinha.api.cache.ApelidoCache;
import com.rinha.rinha.api.service.PessoaService;
import com.rinha.rinha.model.Pessoa;
import jakarta.validation.Valid;
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
    @Autowired
    private PessoaService service;

    @Autowired
    private ApelidoCache apelidoCache;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Pessoa pessoa) {
        if(!pessoa.isValid() || apelidoCache.has(pessoa.getApelido())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Pessoa createdPessoa = service.create(pessoa);
        apelidoCache.add(pessoa.getApelido());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/pessoas/" + createdPessoa.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable UUID id) throws Exception {
        Pessoa pessoa = service.findById(id);
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
