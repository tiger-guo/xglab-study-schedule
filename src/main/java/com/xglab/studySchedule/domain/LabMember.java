package com.xglab.studySchedule.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:52
 **/
@Data
public class LabMember implements Serializable {
    int id;
    String userName;
    String userClass;
    String phoneNumber;
    String password;
    int state;
    int did;
    Date createTime;
    Date modifyTime;
}
