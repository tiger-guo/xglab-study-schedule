package com.xglab.studySchedule.domain.result;

import lombok.Data;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:48
 **/
@Data
public class Result<T> {

    int code;
    String message;
    T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(CodeMsg codeMsg) {
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }

    public static  <T> Result<T> success(T data){
        return new Result<T>(200,"OK",data);
    }

    public static  <T> Result<T> success(){
        return new Result<T>(200,"OK");
    }

    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
}
