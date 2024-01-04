package com.rinha.rinha.api.service;

import com.rinha.rinha.api.repository.PessoaRepository;
import com.rinha.rinha.model.Pessoa;

public class PessoaServiceImpl implements PessoaService{
    private static final PessoaRepository repository = new PessoaRepository();

    public int countPessoas() {
        return repository.countPessoas();
    }

    @Override
    public void createPessoa(Pessoa pessoa) {
        repository.createPessoa(pessoa);
    }


}
