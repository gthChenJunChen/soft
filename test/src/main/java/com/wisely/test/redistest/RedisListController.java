package com.wisely.test.redistest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/redisList")
public class RedisListController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 解决Redis乱码问题
     *
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping(value = "/setLeftList", method = RequestMethod.POST)
    public boolean setLeftList(@RequestBody UserInfo userInfo) {
        boolean result = false;
        try {
            ListOperations<String, String> valueOperations = stringRedisTemplate.opsForList();
            valueOperations.leftPush(userInfo.getId(), userInfo.getName());
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    @RequestMapping(value = "/setRightList", method = RequestMethod.POST)
    public boolean setRightList(@RequestBody UserInfo userInfo) {
        boolean result = false;
        try {
            ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
            listOperations.rightPush(userInfo.getId(), userInfo.getName());
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    @RequestMapping(value = "/getRightListOne", method = RequestMethod.POST)
    public String getRightListOne(@RequestParam(value = "key") String key) {
        String result = null;
        ListOperations<String, String> listOperations = null;
        try {
            listOperations = stringRedisTemplate.opsForList();
            result = listOperations.rightPop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getListIndex", method = RequestMethod.POST)
    public String getListByIndex(@RequestParam(value = "key") String key, @RequestParam(value = "index") Integer index) {
        String result = null;
        try {
            ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
            result = listOperations.index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getListLrange", method = RequestMethod.POST)
    public List<String> getListLrange(@RequestParam(value = "key") String key, @RequestParam("begin") Integer begin, @RequestParam(value = "end") Integer end) {
        List<String> result = null;
        try {
            ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
            result = listOperations.range(key, begin, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/setLeftListJson", method = RequestMethod.POST)
    public boolean setLeftListJson(@RequestBody UserInfo userInfo) {
        boolean result = false;
        try {
            ListOperations<String, String> valueOperations = stringRedisTemplate.opsForList();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(userInfo);
            valueOperations.leftPush(userInfo.getId(), jsonString);
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }
}
