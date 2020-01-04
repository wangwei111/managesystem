/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 * redis揭露
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 0:32
 */
public class RedisKit {


    private static final Logger log = LoggerFactory.getLogger(RedisKit.class);
    private RedisTemplate redisTemplate;
    public static final String REDIS_KEY_SPLITOR = ":";

    public RedisKit() {
    }

    public RedisKit(RedisTemplate redisTemplate) {
        this.redisTemplate =redisTemplate;
    }

    public <V> boolean setIfAbsent(String key, V value) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfAbsent(this.handleKey(key), value).booleanValue();
        } catch (Exception var5) {
            log.error("Redis Execute setIfAbsent Error.Params[{},{}]", new Object[]{key, value, var5});
        }

        return result;
    }

    public <V> boolean setIfAbsent(String key, V value, Duration duration) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfAbsent(this.handleKey(key), value, duration).booleanValue();
        } catch (Exception var6) {
            log.error("Redis Execute setIfAbsent Error.Params[{},{}]", new Object[]{key, value, var6});
        }

        return result;
    }

    public <V> boolean setIfAbsent(String key, V value, long time, TimeUnit timeUnit) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfAbsent(this.handleKey(key), value, time, timeUnit).booleanValue();
        } catch (Exception var8) {
            log.error("Redis Execute setIfAbsent Error.Params[{},{}]", new Object[]{key, value, var8});
        }

        return result;
    }

    public <V> boolean setIfPresent(String key, V value) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfPresent(this.handleKey(key), value).booleanValue();
        } catch (Exception var5) {
            log.error("Redis Execute setIfPresent Error.Params[{},{}]", new Object[]{key, value, var5});
        }

        return result;
    }

    public <V> boolean setIfPresent(String key, V value, Duration duration) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfPresent(this.handleKey(key), value, duration).booleanValue();
        } catch (Exception var6) {
            log.error("Redis Execute setIfPresent Error.Params[{},{}]", new Object[]{key, value, var6});
        }

        return result;
    }

    public <V> boolean setIfPresent(String key, V value, long time, TimeUnit timeUnit) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            result = operations.setIfPresent(this.handleKey(key), value, time, timeUnit).booleanValue();
        } catch (Exception var8) {
            log.error("Redis Execute setIfPresent Error.Params[{},{}]", new Object[]{key, value, var8});
        }

        return result;
    }

    public long increment(String key, long value) {
        try {
            ValueOperations<Serializable, Long> operations = this.redisTemplate.opsForValue();
            return operations.increment(this.handleKey(key), value).longValue();
        } catch (Exception var5) {
            log.error("Redis Execute Increment Error.Params[{},{}]", new Object[]{key, value, var5});
            return 0L;
        }
    }

    public boolean expire(String key, long timeout, TimeUnit unit) {
        try {
            return this.redisTemplate.expire(this.handleKey(key), timeout, unit).booleanValue();
        } catch (Exception var6) {
            log.error("Redis Execute Expire Error.Params[{},{},{}]", new Object[]{key, timeout, unit, var6});
            return false;
        }
    }

    public <V> boolean set(String key, V value) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            operations.set(this.handleKey(key), value);
            result = true;
        } catch (Exception var5) {
            log.error("Redis Execute Error.Params[{},{}]", new Object[]{key, value, var5});
        }

        return result;
    }

    public <V> boolean set(String key, V value, Long expireTime) {
        boolean result = false;

        try {
            return this.set(this.handleKey(key), value, expireTime, TimeUnit.SECONDS);
        } catch (Exception var6) {
            log.error("Redis Execute Error.Params[{},{},{}]", new Object[]{key, value, expireTime, var6});
            return result;
        }
    }

    public <V> boolean set(String key, V value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;

        try {
            ValueOperations<Serializable, V> operations = this.redisTemplate.opsForValue();
            operations.set(this.handleKey(key), value);
            this.redisTemplate.expire(this.handleKey(key), expireTime.longValue(), timeUnit);
            result = true;
        } catch (Exception var7) {
            log.error("Redis Execute Error.Params[{},{},{},{}]", new Object[]{key, value, expireTime, timeUnit, var7});
        }

        return result;
    }

    public void removeAll(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

    public boolean remove(String key) {
        return this.redisTemplate.delete(this.handleKey(key)).booleanValue();
    }

    public void removePattern(String pattern) {
        Set<String> keys = this.getKeys(pattern);
        if (keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }

    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(this.handleKey(key)).booleanValue();
    }

    public <V> V get(String key) {
        V result = null;
        ValueOperations<String, V> operations = this.redisTemplate.opsForValue();
        result = operations.get(this.handleKey(key));
        return result;
    }

    public Set<String> getKeys(String pattern) {
        return this.redisTemplate.keys(this.handleKey(pattern));
    }

    public <HK, V> void hmSet(String key, HK hashKey, V value) {
        HashOperations<String, HK, V> hash = this.redisTemplate.opsForHash();
        hash.put(this.handleKey(key), hashKey, value);
    }

    public <HK, V> void hmSet(String key, HK hashKey, V value, Long expireTime, TimeUnit timeUnit) {
        HashOperations<String, HK, V> hash = this.redisTemplate.opsForHash();
        hash.put(this.handleKey(key), hashKey, value);
        this.redisTemplate.expire(this.handleKey(key), expireTime.longValue(), timeUnit);
    }

    public <HK, V> V hmGet(String key, HK hashKey) {
        HashOperations<String, HK, V> hash = this.redisTemplate.opsForHash();
        return hash.get(this.handleKey(key), hashKey);
    }

    public <V> void lPush(String key, V v) {
        ListOperations<String, V> list = this.redisTemplate.opsForList();
        list.rightPush(this.handleKey(key), v);
    }

    public <V> List<V> lRange(String key, long l, long l1) {
        ListOperations<String, V> list = this.redisTemplate.opsForList();
        return list.range(this.handleKey(key), l, l1);
    }

    public <V> void add(String key, V value) {
        SetOperations<String, V> set = this.redisTemplate.opsForSet();
        set.add(this.handleKey(key), (V) new Object[]{value});
    }

    public <V> Set<V> setMembers(String key) {
        SetOperations<String, V> set = this.redisTemplate.opsForSet();
        return set.members(this.handleKey(key));
    }

    public <V> void zAdd(String key, V value, double scoure) {
        ZSetOperations<String, V> zset = this.redisTemplate.opsForZSet();
        zset.add(this.handleKey(key), value, scoure);
    }

    public <V> Set<V> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, V> zset = this.redisTemplate.opsForZSet();
        return zset.rangeByScore(this.handleKey(key), scoure, scoure1);
    }
/*
    public boolean acquireLock(String lockKey, String value, long expireTime) {
        ExceptionHolder.throwNull(lockKey, "The Lock Key Must Be Not NUll.", new Object[0]);
        return this.setIfAbsent(this.handleKey("LCK:" + lockKey), value, expireTime, TimeUnit.MILLISECONDS);
    }

    public boolean releaseLock(String lockKey) {
        ExceptionHolder.throwNull(lockKey, "The Lock Key Must Be Not NUll.", new Object[0]);
        return this.remove(this.handleKey("LCK:" + lockKey));
    }

    private String handleKey(String originKey) {
        return this.systemPropertiesConfig.getRedisNamespace() + ":" + this.systemPropertiesConfig.getProfile() + ":" + originKey;
    }*/

    private String handleKey(String originKey) {
        return "dev:redis"+ ":" + originKey;
    }
}
