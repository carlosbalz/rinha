package com.rinha.rinha.api.service;

import com.rinha.rinha.api.repository.PessoaRepository;
import com.rinha.rinha.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository repository;

    private static final Queue<Pessoa> queue = new ConcurrentLinkedQueue<>();

    public void create(Pessoa pessoa) {
        queue.add(pessoa);
    }

    public List<Pessoa> findByTermo(String termo) {
        return repository.findByTermo(termo);
    }

    public long count() {
        return repository.findAll().size();
    }

    @Scheduled(fixedDelay = 2000)
    private void batchInsertPessoas() {
        Queue<Pessoa> pessoas = new ConcurrentLinkedQueue<>();
        for(int i = 0; i < queue.size(); i++) {
            pessoas.add(queue.poll());
        }
        if(pessoas.isEmpty()) return;
        repository.saveAll(pessoas);
    }

}
