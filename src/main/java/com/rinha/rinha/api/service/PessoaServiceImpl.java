package com.rinha.rinha.api.service;

import com.rinha.rinha.api.repository.PessoaRepository;

public class PessoaServiceImpl implements PessoaService{
    private static final PessoaRepository repository = new PessoaRepository();

    public int countPessoas() {
        return repository.countPessoas();
    }
}
