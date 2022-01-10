package com.redisdemo;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Cola
 * @description RedisService
 * @date 2022/1/10
 * @email 1020151695@qq.com
 */
@Service
public class RedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        // 10s 过期
        valueOperations.set(key, value,10, TimeUnit.SECONDS);
    }
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

}
