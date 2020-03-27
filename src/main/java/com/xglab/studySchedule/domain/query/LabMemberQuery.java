package com.xglab.studySchedule.domain.query;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-27 11:01
 **/
@Data
public class LabMemberQuery implements Serializable {
    int id;
    String userName;
    String userClass;
    String phoneNumber;
    String password;
    int state;
    Date createTime;
    Date modifyTime;
}
