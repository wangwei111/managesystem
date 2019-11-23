/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.config.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 0:37
 */
@Component
public class RedisDistributedLock {
    private static final Logger log = LoggerFactory.getLogger(RedisDistributedLock.class);

    /**
     * 将key放到前线程变量，释放时就不需要指定key，直接调用unlock（）即可
     */
    private  static  final  ThreadLocal<String> LOCK_KEY_HOLDER= new ThreadLocal<>();

    /**
     * 默认锁失效时间80秒
     */
    private  static final long DEFAULT_LOCK_TIME_OUT =80000;

    /**
     * 默认获取锁的尝试次数1次
     */
    public static final int TRY_LOCK_TIMES =1;
    @Autowired
    private RedisKit redisKit;

    /**
     *
     * @param key
     * @param waitLockTimeout 等待redis锁的时间
     * @param tryLockTimes 上锁时间
     * @return
     */
    public  boolean lock(String key, long waitLockTimeout,long locktimeout, int tryLockTimes){
        LOCK_KEY_HOLDER.set(key);
        long start = System.currentTimeMillis();
        boolean success = false;
        --tryLockTimes;
        try{
            while ((System.currentTimeMillis()-start)<waitLockTimeout){
                if(redisKit.setIfAbsent(key,key)){
                    redisKit.expire(key,locktimeout,TimeUnit.MILLISECONDS);
                    if(log.isDebugEnabled()){
                        log.debug("add RedisDistributedLock["+key+"].");
                    }
                    success= true;
                    break;
                }
                TimeUnit.SECONDS.sleep(3);
            }
            if(!success && tryLockTimes>0){
                log.info("Try Get Lock["+key+"].");
                lock(key,waitLockTimeout,locktimeout,tryLockTimes);
            }
        }catch (Exception e){
            unlock(key);
            log.error(e.getMessage());
        }
        return success;
    }

    public boolean lock(String key,long waitLockTimeout){
        return lock(key,waitLockTimeout,DEFAULT_LOCK_TIME_OUT,TRY_LOCK_TIMES);
    }

    public boolean lockWithLockTimeout(String key,long lockTimeout){
        log.info("lock kye:{} timeout:{}" ,key,lockTimeout);
        LOCK_KEY_HOLDER.set(key);
        try {
            if(redisKit.setIfAbsent(key,key)){
                redisKit.expire(key,lockTimeout,TimeUnit.MILLISECONDS);
                return true;
            }
        }catch (Exception e){
            unlock(key);
            log.error("lock error lockKey:"+key,e);
        }
        return  false;
    }


    public void unlock(String key) {
        LOCK_KEY_HOLDER.remove();
        log.info("release RedisDistributedLock:{}"+key);
        redisKit.remove(key);
    }

    public void  unlock(){
        String lockKey = LOCK_KEY_HOLDER.get();
        if(log.isDebugEnabled()){
            log.debug("release RedisDistributedLock:{}"+lockKey);
        }
        unlock(lockKey);
    }
}
