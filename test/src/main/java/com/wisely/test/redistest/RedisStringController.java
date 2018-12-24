package com.wisely.test.redistest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "redisString")
public class RedisStringController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/setValue", method = RequestMethod.POST)
    public boolean setValue(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value, @RequestParam("expire") Long expire) {
        boolean result = false;
        try {
            ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
            valueOperations.set(key, value);
            stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    public String getValue(@RequestParam(value = "key") String key) {
        String result = null;
        try {
            ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
            result = valueOperations.get(key);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    @RequestMapping(value = "/delKey", method = RequestMethod.POST)
    public boolean delKey(@RequestParam(value = "key") String key) {
        return stringRedisTemplate.delete(key);
    }
}
