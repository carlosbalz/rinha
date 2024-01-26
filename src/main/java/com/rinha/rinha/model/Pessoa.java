package com.rinha.rinha.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pessoa", schema = "public")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "apelido", nullable = false, length = 32, unique = true)
    private String apelido;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "nascimento", nullable = false, length = 10)
    private String nascimento;

    @Column(name = "stack", columnDefinition = "text")
    private String[] stack;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String[] getStack() {
        return stack;
    }

    public void setStack(String[] stack) {
        this.stack = stack;
    }

}
