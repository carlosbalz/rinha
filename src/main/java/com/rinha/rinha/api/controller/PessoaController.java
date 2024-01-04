package com.rinha.rinha.api.controller;

import com.rinha.rinha.api.service.PessoaService;
import com.rinha.rinha.api.service.PessoaServiceImpl;
import com.rinha.rinha.model.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private static final PessoaService service = new PessoaServiceImpl();

    @GetMapping(value="/")
    public String hello(){
        return "Hello World!!";
    }

    @PostMapping("/pessoas")
    public void create(@RequestBody Pessoa pessoa) {
        logger.error("NOME: {}", pessoa.getNome());
        service.createPessoa(pessoa);
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa getPessoa(@PathVariable String id) {
        return new Pessoa();
    }

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(@RequestParam String termo) {
        return new ArrayList<>();
    }

    @GetMapping("/contagem-pessoas")
    public int countPessoas() {
        return service.countPessoas();
    }
}
