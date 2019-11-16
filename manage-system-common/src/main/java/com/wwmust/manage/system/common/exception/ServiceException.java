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
 * 业务异常
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 15:17
 */
public class ServiceException extends  BaseRuntimeException {

    public ServiceException(){super();}

    public ServiceException(String message){
        super(message);
    }
    public ServiceException(String message,Throwable cause){
        super(message,cause);
    }
    public  ServiceException(Throwable casue){
        super(casue);
    }
    public ServiceException(String message,Throwable cause,String errorCode){
        super(message,cause,errorCode);
    }
    public ServiceException(String message,String errorCode){
        super(message,errorCode);
    }
    public ServiceException(Throwable cause,String errorCode){
        super(cause,errorCode);
    }
}
