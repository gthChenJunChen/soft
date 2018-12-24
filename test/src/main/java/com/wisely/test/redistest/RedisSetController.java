package com.wisely.test.redistest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "redisSet")
public class RedisSetController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/setSet", method = RequestMethod.POST)
    public Long setSet(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        Long result = null;
        try {
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            result = setOperations.add(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getMembersSet", method = RequestMethod.GET)
    public Set<String> getMembersSet(@RequestParam(value = "key") String key) {
        Set<String> strings = null;
        try {
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            strings = setOperations.members(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    @RequestMapping(value = "/remSet", method = RequestMethod.POST)
    public Long remSet(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        Long nu = null;
        try {
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            nu = setOperations.remove(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nu;
    }

    @RequestMapping(value = "/isMember", method = RequestMethod.POST)
    public boolean isMember(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        boolean result = false;
        try {
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            result = setOperations.isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
        /**
         * set get del
         * lpush rpush lpop rpop lrange lindex
         * sadd smembers sismember srem sinter sunion sdiff
         * */
    }

}
