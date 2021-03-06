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
 * api接口请求异常
 * @author 37079<37079@wwmust.com>
 * @date 11/11/2019 19:59
 */
public class ApiException extends  BaseRuntimeException{

    public ApiException(){super();}

    public ApiException(String message){
        super(message);
    }
    public ApiException(String message,Throwable cause){
        super(message,cause);
    }
    public  ApiException(Throwable casue){
        super(casue);
    }
    public ApiException(String message,Throwable cause,String errorCode){
        super(message,cause,errorCode);
    }
    public ApiException(String message,String errorCode){
        super(message,errorCode);
    }
    public ApiException(Throwable cause,String errorCode){
        super(cause,errorCode);
    }
}
