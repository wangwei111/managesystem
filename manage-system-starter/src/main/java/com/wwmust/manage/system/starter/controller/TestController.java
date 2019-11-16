/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust  project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller;

import org.junit.jupiter.api.Test;
import sun.nio.ch.ThreadPool;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author 37079<37079@wwmust.com>
 * @date 11/11/2019 16:54
 */
public class TestController {

    /**
     * 使用ThreadPool线程池（线程池大小为3）
     * [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]每个线程只允许随机取出1个，取出后删除直到数组为空，取出的结果重新放到另一数组中
     */
    @Test
    public  void test(){

        System.out.println("ss");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread();
            }
        }, new ThreadPoolExecutor.AbortPolicy());

       final  String[] strs = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
        while (true){
            Thread thread = threadPoolExecutor.getThreadFactory().newThread(new Runnable() {
                @Override
                public void run() {
                    double random = Math.random();
                    int i = new Random().nextInt(strs.length);
                    List<String> strings = Arrays.asList(strs);
                    strings.remove(i);
                    System.out.println(strs[i]);
                }

            });
            thread.start();


        }


    }
}
