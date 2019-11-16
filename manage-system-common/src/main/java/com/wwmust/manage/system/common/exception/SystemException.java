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
 * 系统异常
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 15:18
 */
public class SystemException extends BaseRuntimeException {
    public SystemException(){super();}

    public SystemException(String message){
        super(message);
    }
    public SystemException(String message,Throwable cause){
        super(message,cause);
    }
    public  SystemException(Throwable casue){
        super(casue);
    }
    public SystemException(String message,Throwable cause,String errorCode){
        super(message,cause,errorCode);
    }
    public SystemException(String message,String errorCode){
        super(message,errorCode);
    }
    public SystemException(Throwable cause,String errorCode){
        super(cause,errorCode);
    }
}
