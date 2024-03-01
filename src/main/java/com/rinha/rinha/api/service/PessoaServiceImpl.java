package com.rinha.rinha.api.service;

import com.rinha.rinha.api.repository.PessoaRepository;
import com.rinha.rinha.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository repository;

    public Pessoa create(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa findById(UUID id) throws Exception {
        Optional<Pessoa> pessoa = Optional.of(repository.getReferenceById(id));
        return pessoa.orElseThrow(() -> new Exception("Não foi possível encontrar uma pessoa com o id: " + id));
    }

    public List<Pessoa> findByTermo(String termo) {
        return repository.findByTermo(termo);
    }

    public long count() {
        return repository.count();
    }

    public boolean apelidoExists(String apelido) {
        List<Pessoa> pessoas = repository.findByApelido(apelido);
        return pessoas != null && !pessoas.isEmpty();
    }

}
