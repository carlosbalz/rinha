package com.rinha.rinha.api.controller;

import com.rinha.rinha.api.service.PessoaService;
import com.rinha.rinha.model.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    PessoaService service;

    @PostMapping("/")
    public void create(@RequestBody Pessoa pessoa) {
        logger.error("NOME: {}", pessoa.getNome());
        service.create(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable UUID id) throws Exception {
        Pessoa pessoa = service.findById(id);
        logger.error("NOME: {}", pessoa.getNome());
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("")
    public ResponseEntity<List<Pessoa>> findByTermo(@RequestParam("t") String t) {
        return ResponseEntity.ok(service.findByTermo(t));
    }

    @GetMapping("/contagem-pessoas")
    public long count() {
        return service.count();
    }
}
