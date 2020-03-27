package com.xglab.studySchedule.domain.enumUtil;

/**
 * @program: projectName
 * @description: 成员状态
 * @author: liuguohu
 * @create: 2020-03-27 20:46
 **/

public enum MemberStateEnum {

    IN_LAB(1, "In The XGLAB!"),
    TO_GRADUATE(0,"To GRADUATE!"),
    LEAVE_LAB(-1,"LEAVE!");
    ;

    MemberStateEnum(int type, String describe) {
        this.type = type;
        this.describe = describe;
    }

    private int type;
    private String describe;


    public int getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }
}
