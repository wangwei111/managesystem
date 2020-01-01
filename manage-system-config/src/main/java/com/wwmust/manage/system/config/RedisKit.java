/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.config;


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
public interface RedisKit {
    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfAbsent(final String key,V value);

    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfAbsent(final String key, V value, Duration duration);

    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfAbsent(final String key, V value, long time,TimeUnit timeUnit);

    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfPresent(final String key, V value);
    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfPresent(final String key, V value,Duration duration);
    /**
     * 如果不存在就设置，否则不设置
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean setIfPresent(final String key, V value,long time,TimeUnit timeUnit);

    /**
     * 先检查key是否存在，存中加1，不存在先初始化，在加1
     * @param key
     * @param value
     * @return
     */
    long increment(final String key,long value);

    /**
     * 设置缓存失效时间
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    boolean expire(String key, final long timeout, final TimeUnit unit);

    /**
     * 写入缓存
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> boolean set(final  String key,V value);


    /**
     * 写入缓存设置失效时间
     * @param key
     * @param value
     * @param exprieTime
     * @param <V>
     * @return
     */
    <V> boolean set(final  String key,V value,Long exprieTime);

    /**
     * 写入缓存设置失效时间
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @param <V>
     * @return
     */
    <V> boolean set(final  String key,V value,Long expireTime,TimeUnit timeUnit);


    /**
     * 批量删除对应的value
     * @param keys
     */
    void removeAll(final String... keys);

    /**
     * 删除对应的value
     * @param key
     * @return
     */
    boolean remove(final String key);

    /**
     * 批量删除key
     * @param pattern
     */
    void removePattern(final  String pattern);

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    boolean exists(final  String key);

    /**
     * 读取缓存
     * @param key
     * @param <V>
     * @return
     */
    <V> V get(final  String key);

    /**
     * 获取符合规则匹配的key
     * @param pattern
     * @return
     */
    Set<String> getKeys(String pattern);

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     * @param <T>
     * @param <V>
     */
    <T,V> void hmSet(String key ,T hashKey,V value);

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     * @param expireTime
     * @param timeUnit
     * @param <T>
     * @param <V>
     */
    <T,V> void hmSet(String key ,T hashKey,V value,Long expireTime,TimeUnit timeUnit);


    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @param <T>
     * @param <V>
     * @return
     */
    <T,V> V  hmGet(String key ,T hashKey);

    /**
     * 列表添加
     * @param key
     * @param v
     * @param <V>
     */
    <V> void lPush(String key, V v);

    /**
     * 列表获获取
     * @param key
     * @param l
     * @param l1
     * @param <V>
     * @return
     */
    <V> List<V> lRange(String key, long l,long l1);

    /**
     * 集合添加
     * @param key
     * @param value
     * @param <V>
     */
    <V> void add(String key,V value);

    /**
     * 集合获取
     * @param key
     * @param <V>
     * @return
     */
    <V> Set<V> setMembers(String key);


    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     * @param <V>
     */
    <V> void zAdd(String key,V value,double scoure);
    /**
     * 有序集合添加
     * @param key
     * @param source1
     * @param scoure
     * @param <V>
     */
    <V> Set<V> rangeByScore(String key,double scoure,double source1);

    /**
     * 枷锁
     * @param lockKey 锁key
     * @param value 锁名
     * @param expireTime 失效时间
     * @return
     */
    boolean acquireLock(String lockKey,String value,long expireTime);

    /**
     * 释放锁
     * @param lockKey
     * @return
     */
    boolean releaseLock(String lockKey);

    /**
     * 处理key添加前缀
     * @param originKey
     * @return
     */
    String handleKey(String originKey);
}
