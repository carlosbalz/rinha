package com.rinha.rinha.api.service;

import com.rinha.rinha.model.Pessoa;

public interface PessoaService {
    public int countPessoas();

    void createPessoa(Pessoa pessoa);
}
