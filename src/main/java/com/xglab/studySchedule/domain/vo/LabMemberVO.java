package com.xglab.studySchedule.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-27 19:41
 **/
@Data
public class LabMemberVO implements Serializable {
    int id;
    String userName;
    String userClass;
    String phoneNumber;
    String password;
    int state;
}
