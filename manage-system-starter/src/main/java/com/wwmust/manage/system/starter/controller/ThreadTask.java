/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author 37079<37079@wwmust.com>
 * @date 11/11/2019 18:50
 */
public class ThreadTask implements  Runnable {
    String[] strs = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};

    @Override
    public void run() {

        double random = Math.random();
        int i = new Random().nextInt(strs.length);
        List<String> strings = Arrays.asList(strs);
        strings.remove(i);
        System.out.println(strs[i]);
    }
}
