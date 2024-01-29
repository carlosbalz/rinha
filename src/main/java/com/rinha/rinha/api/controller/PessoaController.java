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
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    PessoaService service;

    @PostMapping("/pessoas")
    public void create(@RequestBody Pessoa pessoa) {
        logger.error("NOME: {}", pessoa.getNome());
        service.create(pessoa);
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable UUID id) throws Exception {
        Pessoa pessoa = service.findById(id);
        logger.error("NOME: {}", pessoa.getNome());
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/pessoas")
    public List<Pessoa> findByTermo(@RequestParam String termo) {
        return service.findByTermo(termo);
    }

    @GetMapping("/contagem-pessoas")
    public long count() {
        return service.count();
    }
}
