package com.xglab.studySchedule.domain.result;

/**
 * @program: projectName
 * @description: 返回信息及提示信息
 * @author: liuguohu
 * @create: 2020-03-27 09:07
 **/

public enum CodeMsg {

    NOT_EXIST_USER(5001,"用户不存在！"),
    PARAM_IS_NULL(5000,"参数为空");
    ;


    private int code;
    private String message;

    CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
