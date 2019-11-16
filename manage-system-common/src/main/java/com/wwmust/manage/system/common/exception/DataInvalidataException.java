/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.common.exception;

/**
 * ${DESCRIPTION}
 *  数据校验异常
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 15:15
 */
public class DataInvalidataException  extends  BaseRuntimeException{
    public DataInvalidataException(){super();}

    public DataInvalidataException(String message){
        super(message);
    }
    public DataInvalidataException(String message,Throwable cause){
        super(message,cause);
    }
    public  DataInvalidataException(Throwable casue){
        super(casue);
    }
    public DataInvalidataException(String message,Throwable cause,String errorCode){
        super(message,cause,errorCode);
    }
    public DataInvalidataException(String message,String errorCode){
        super(message,errorCode);
    }
    public DataInvalidataException(Throwable cause,String errorCode){
        super(cause,errorCode);
    }
}
