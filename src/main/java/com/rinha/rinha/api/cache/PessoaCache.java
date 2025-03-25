package com.rinha.rinha.api.cache;

import com.google.gson.Gson;
import com.rinha.rinha.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PessoaCache {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private Gson json;

    public void add(Pessoa pessoa) {
        redisTemplate.opsForValue().set(pessoa.getApelido(), "ap");
        redisTemplate.opsForValue().set(pessoa.getId().toString(), json.toJson(pessoa));
    }

    public boolean hasApelido(String apelido) {
        return redisTemplate.opsForValue().get(apelido) != null;
    }

    public Pessoa findById(UUID id) {
        try {
            return json.fromJson(redisTemplate.opsForValue().get(id.toString()), Pessoa.class);
        } catch (Exception e) {
            return null;
        }
    }

}
