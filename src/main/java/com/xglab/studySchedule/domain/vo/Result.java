package com.xglab.studySchedule.domain.vo;

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
}
