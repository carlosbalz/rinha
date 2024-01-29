package com.rinha.rinha.api.service;

import com.rinha.rinha.model.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaService {

    public void create(Pessoa pessoa);

    public Pessoa findById(UUID id) throws Exception;

    public List<Pessoa> findByTermo(String termo);

    public long count();
}
