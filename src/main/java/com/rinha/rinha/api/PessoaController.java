package com.rinha.rinha.api;

import com.rinha.rinha.model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {

    @GetMapping(value="/")
    public String hello(){
        return "Hello World!!";
    }

    @PostMapping("/pessoas")
    public void create(@RequestBody Pessoa pessoa) {

    }

    @GetMapping("/pessoas/{id}")
    public Pessoa getPessoa(@PathVariable String id) {
        return new Pessoa();
    }

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(@RequestParam String termo) {
        return new ArrayList<Pessoa>();
    }

    @GetMapping("/contagem-pessoas")
    public int countPessoas() {
        return 0;
    }
}
