package com.rinha.rinha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pessoa", schema = "public")
public class Pessoa {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "apelido", nullable = false, length = 32, unique = true)
    private String apelido;

    @Pattern(regexp = "^([a-zA-ZÀ-ÖØ-öø-ÿ]+\s?)+$", message = "o nome deve conter somente letras")
    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "nascimento", nullable = false, length = 10)
    private String nascimento;

    @Column(name = "stack", columnDefinition = "VARCHAR(32)[]")
    private List<String> stack;

    public Pessoa() {

    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }
    public UUID getId() {
        return id;
    }

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

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    @JsonIgnore
    public boolean isValid(){
        return isApelidoValid() && isNomeValid() && isNascimentoValid() && isStackValid();
    }
    private boolean isApelidoValid(){
        return apelido != null && !apelido.isEmpty() && apelido.length() < 32;
    }
    private boolean isNomeValid(){
        return nome != null && !nome.isEmpty() && nome.length() < 100;
    }
    private boolean isNascimentoValid(){
        return nascimento != null && isValidDate(nascimento);
    }
    private boolean isStackValid(){
        return stack == null || (!stack.isEmpty() && stack.stream().allMatch(x -> x != null && x.length() < 32));
    }

    private boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
