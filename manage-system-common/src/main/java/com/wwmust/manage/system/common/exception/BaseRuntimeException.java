/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.common.exception;

import com.alibaba.fastjson.JSONObject;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 14:50
 */
public class BaseRuntimeException extends RuntimeException {
    private String errorCode;
    private JSONObject parameterObject;
    private Object[] parameterVariable;

    private  boolean warning = false;
    private JSONObject warningData;
    public  BaseRuntimeException(){
        super();
    }
    public BaseRuntimeException(String message){
        super(message);
    }
    public BaseRuntimeException(String message,Throwable cause){
        super(message,cause);
    }
    public BaseRuntimeException(Throwable cause){
        super(cause!=null?cause.getMessage():"BaseRuntimeException",cause);
    }
    public  BaseRuntimeException(String message,String errorCode){
        super(message);
        this.errorCode =errorCode;
    }
    public BaseRuntimeException(String message,Throwable cause,String errorCode){
        super(message,cause);
        this.errorCode =errorCode;
    }
    public BaseRuntimeException(Throwable cause,String errorCode){
        super(cause);
        this.errorCode = errorCode;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public JSONObject getParameterObject() {
        return parameterObject;
    }

    public void setParameterObject(JSONObject parameterObject) {
        this.parameterObject = parameterObject;
    }

    public Object[] getParameterVariable() {
        return parameterVariable;
    }

    public void setParameterVariable(Object[] parameterVariable) {
        this.parameterVariable = parameterVariable;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }

    public JSONObject getWarningData() {
        return warningData;
    }

    public void setWarningData(JSONObject warningData) {
        this.warningData = warningData;
    }
    public  BaseRuntimeException buildErrorCode (String errorCode){
        this.setErrorCode(errorCode);
        return  this;
    }
    public  BaseRuntimeException buildParameterObject(JSONObject parameterObject){
        this.setParameterObject(parameterObject);
        return  this;
    }
    public BaseRuntimeException putParameterObject(String key,Object value){
        if(this.parameterObject == null){
            this.parameterObject = new JSONObject();
        }
        this.getParameterObject().put(key,value);
        return this;
    }
    public BaseRuntimeException buildParameterVariable(Object... parameterVariable){
        this.setParameterVariable(parameterVariable);
        return  this;
    }
    public BaseRuntimeException warning(JSONObject warningData){
        this.warning = true;
        this.warningData = warningData;
        return  this;
    }

    public  BaseRuntimeException waring(){
        return  warning(null);
    }
}
