package com.rinha.rinha.api.service;

import com.rinha.rinha.api.repository.PessoaRepository;
import com.rinha.rinha.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository repository;

    public void create(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public Pessoa findById(UUID id) throws Exception {
        Optional<Pessoa> result = Optional.of(repository.getReferenceById(id));
        return result.orElseThrow(() -> new Exception("Não foi possível encontrar uma pessoa com o id: " + id));
    }

    public List<Pessoa> findByTermo(String termo) {
        return repository.findByTermo(termo);
    }

    public long count() {
        return repository.count();
    }

}
