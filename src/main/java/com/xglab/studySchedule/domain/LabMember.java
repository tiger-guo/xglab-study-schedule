package com.xglab.studySchedule.domain;

import lombok.Data;

import java.util.Date;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:52
 **/
@Data
public class LabMember {
    int id;
    String userName;
    String userClass;
    String phoneNumber;
    String password;
    int state;
    Date createTime;
    Date modifyTime;
}
