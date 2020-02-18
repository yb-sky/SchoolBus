package com.talkweb.edu.util;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author SKyOne
 * @create 2020-02-12 16:09
 */
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public Result(){}

    public Result(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result<T> success(String msg){
        return new Result(0, StringUtils.isEmpty(msg) ? "success" : msg);
    }

    public Result<T> faile(String msg){
        return new Result(-1, StringUtils.isEmpty(msg) ? "faile" : msg);
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
