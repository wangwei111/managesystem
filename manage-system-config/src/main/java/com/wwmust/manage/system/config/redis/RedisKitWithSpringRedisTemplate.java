/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.config.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 1:03
 */
@Component
public class RedisKitWithSpringRedisTemplate implements  RedisKit {

    private  static  final Logger log =  LoggerFactory.getLogger(RedisKitWithSpringRedisTemplate.class.getSimpleName());

    private  static  final  String ERROR_REDIS ="Redis Execute setIfAbsent Error.Params[{},{}]";
    @Autowired
    private RedisTemplate redisTemplate;

    public  RedisKitWithSpringRedisTemplate(){}

    public RedisKitWithSpringRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate =redisTemplate;
    }

    @Override
    public <V> boolean setIfAbsent(String key, V value) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfAbsent(handleKey(key),value);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;
    }

    @Override
    public <V> boolean setIfAbsent(String key, V value, Duration duration) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfAbsent(handleKey(key),value,duration);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;    }

    @Override
    public <V> boolean setIfAbsent(String key, V value, long time, TimeUnit timeUnit) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfAbsent(handleKey(key),value,time,timeUnit);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;
    }

    @Override
    public <V> boolean setIfPresent(String key, V value) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfPresent(handleKey(key),value);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;
    }

    @Override
    public <V> boolean setIfPresent(String key, V value, Duration duration) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfPresent(handleKey(key),value,duration);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;
    }

    @Override
    public <V> boolean setIfPresent(String key, V value, long time, TimeUnit timeUnit) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            result =operations.setIfPresent(handleKey(key),value,time,timeUnit);
        }catch (Exception e){
            log.error(ERROR_REDIS,key,value,e);
        }
        return result;
    }

    @Override
    public long increment(String key, long value) {
        try {
            ValueOperations<Serializable,Long> operations = redisTemplate.opsForValue();
            return operations.increment(handleKey(key),value);
        }catch (Exception e){
            log.error("Redis Execute Increment Error.Params[{},{}]",key,value,e);
        }
        return 0L;
    }

    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        try {
            return redisTemplate.expire(handleKey(key),timeout,unit);
        }catch (Exception e){
            log.error("Redis Execute Increment Error.Params[{},{},{}]",key,timeout,unit,e);

        }
        return false;
    }

    @Override
    public <V> boolean set(String key, V value) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            operations.set(handleKey(key),value);
            return  true;
        }catch (Exception e){
            log.error("Redis Execute Increment Error.Params[{},{}]",key,value,e);
        }
        return result;
    }

    @Override
    public <V> boolean set(String key, V value, Long exprieTime) {
        boolean result =false;
        try {
            return   set(handleKey(key),value,exprieTime,TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("Redis Execute Increment Error.Params[{},{},{}]",key,value,exprieTime,e);
        }
        return result;
    }


    @Override
    public <V> boolean set(String key, V value, Long expireTime, TimeUnit timeUnit) {
        boolean result =false;
        try {
            ValueOperations<Serializable,V> operations = redisTemplate.opsForValue();
            operations.set(handleKey(key),value);
            redisTemplate.expire(handleKey(key),expireTime,timeUnit);
            return  true;
        }catch (Exception e){
            log.error("Redis Execute Increment Error.Params[{},{},{},{}]",key,value,expireTime,timeUnit,e);
        }
        return result;
    }

    @Override
    public void removeAll(String... keys) {
        for(String key:keys){
            remove(key);
        }

    }

    @Override
    public boolean remove(String key) {
        return redisTemplate.delete(handleKey(key));
    }

    @Override
    public void removePattern(String pattern) {
        Set<String> keys = getKeys(pattern);
        if(!CollectionUtils.isEmpty(keys)){
            redisTemplate.delete(keys);
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(handleKey(key));
    }

    @Override
    public <V> V get(String key) {
        V result = null;
        ValueOperations<String,V> operations = redisTemplate.opsForValue();
        result = operations.get(handleKey(key));
        return result;
    }

    @Override
    public Set<String> getKeys(String pattern) {
        return redisTemplate.keys(handleKey(pattern));
    }

    @Override
    public <T, V> void hmSet(String key, T hashKey, V value) {
        HashOperations<String,T,V> hash = redisTemplate.opsForHash();
        hash.put(handleKey(key),hashKey,value);
    }

    @Override
    public <T, V> void hmSet(String key, T hashKey, V value, Long expireTime, TimeUnit timeUnit) {
        HashOperations<String,T,V> hash = redisTemplate.opsForHash();
        hash.put(handleKey(key),hashKey,value);
        redisTemplate.expire(handleKey(key),expireTime,timeUnit);
    }

    @Override
    public <T, V> V hmGet(String key, T hashKey) {
        String handledKey = handleKey(key);
        HashOperations<String,T,V> hash = redisTemplate.opsForHash();
        return hash.get(handledKey,hashKey);
    }

    @Override
    public <V> void lPush(String key, V v) {
        ListOperations<String ,V> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(handleKey(key),v);
    }

    @Override
    public <V> List<V> lRange(String key, long l, long l1) {
        ListOperations<String ,V> listOperations = redisTemplate.opsForList();
        return listOperations.range(handleKey(key),l,l1);
    }

    @Override
    public <V> void add(String key, V value) {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(handleKey(key),value);

    }

    @Override
    public <V> Set<V> setMembers(String key) {
        SetOperations setOperations = redisTemplate.opsForSet();
        return setOperations.members(handleKey(key));
    }

    @Override
    public <V> void zAdd(String key, V value, double scoure) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(handleKey(key),value,scoure);
    }

    @Override
    public <V> Set<V> rangeByScore(String key, double scoure, double source1) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(handleKey(key),scoure,source1);
    }

    @Override
    public boolean acquireLock(String lockKey, String value, long expireTime) {
        return setIfAbsent(handleKey("LCK:"+lockKey), value,expireTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean releaseLock(String lockKey) {
        return remove(handleKey("LCK:"+lockKey));
    }

    /**
     * 处理key添加前缀
     * @param originKey
     * @return
     */
    @Override
    public String handleKey(String originKey) {
        String handledKey;
        if("dev".equalsIgnoreCase("")){
            handledKey = "redis:dev";
        }else {
            handledKey = "redis:prd";

        }
        handledKey  = handledKey.toUpperCase();
        log.info("redis key {}",handledKey);
        if(log.isDebugEnabled()){
            log.debug("redis complete key: [{}]" ,handledKey);
        }
        return handledKey;
    }
}
