package com.patrol.common;


import com.patrol.common.enums.ResultCode;

import java.io.Serializable;

/***
 * 封装的公共返回结果类
 *
 * @author WangSheng/2019-10-12
 *
 */
public class Result<T> implements Serializable {


    private int code;
    private String msg;
    private int count;
    private T data;
    private Boolean success = Boolean.FALSE;

    private Result(ResultCode resultCode){
       this.code = resultCode.code;
       this.msg = resultCode.msg;
       if(resultCode.equals(ResultCode.CODE_0)){
           success = Boolean.TRUE;
       }
    }

    public static Result success(){
        return new Result(ResultCode.CODE_0);
    }

    public static Result<Object> success(Object data){
        Result<Object> result = new Result<>(ResultCode.CODE_0);
        result.setData(data);
        return result;
    }

    public static Result error(){
        return new Result(ResultCode.CODE_1);
    }

    public static Result error(ResultCode resultCode){
        return new Result(resultCode);
    }

    public static  Result success(ResultCode resultCode){
        return new Result(resultCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
