package com.rinha.rinha.api.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApelidoCache {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(String apelido) {
        redisTemplate.opsForValue().set(apelido, "ap");
    }

    public boolean has(String apelido) {
        return redisTemplate.opsForValue().get(apelido) != null;
    }



}
