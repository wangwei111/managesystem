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
 * 视图层请求异常
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 15:19
 */
public class WebException  extends BaseRuntimeException{
    public WebException(){super();}

    public WebException(String message){
        super(message);
    }
    public WebException(String message,Throwable cause){
        super(message,cause);
    }
    public  WebException(Throwable casue){
        super(casue);
    }
    public WebException(String message,Throwable cause,String errorCode){
        super(message,cause,errorCode);
    }
    public WebException(String message,String errorCode){
        super(message,errorCode);
    }
    public WebException(Throwable cause,String errorCode){
        super(cause,errorCode);
    }
}
