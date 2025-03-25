package com.rinha.rinha.api.service;

import com.rinha.rinha.entity.Pessoa;

import java.util.List;

public interface PessoaService {

    public void create(Pessoa pessoa);

    public List<Pessoa> findByTermo(String termo);

    public long count();

}
