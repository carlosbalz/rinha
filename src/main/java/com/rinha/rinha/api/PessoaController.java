package com.rinha.rinha.api;

import com.rinha.rinha.model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
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
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rinha","cbalz","123")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT COUNT(*) AS TOTAL FROM PESSOA");
            return result.getInt("total");
        } catch (SQLException e) {

        }
        return 0;
    }
}
