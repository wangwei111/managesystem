/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wwmust.manage.system.config.SnowflakeWorker;
import org.junit.jupiter.api.Test;

/**
 * ${DESCRIPTION}
 *测试主键id
 * @author wangwei<wwfdqc@126.com>
 * @date 11/22/2019 9:28
 */
public class TestGenerateID {


    @Test
    public  void getGenerateId(){

        Thread thread= new Thread() {
            public void run() {
                for(int i=0;i<100000;i++){
                    Long aLong = SnowflakeWorker.generateId();
                    System.out.println(aLong);
                }
            }
        };
        thread.start();
        thread.run();

        Thread thread1= new Thread() {
            public void run() {
                for(int i=0;i<100000;i++){
                    Long aLong = SnowflakeWorker.generateId();
                    System.out.println(aLong);
                }
            }
        };
        thread1.start();
        thread1.run();
    }
}
