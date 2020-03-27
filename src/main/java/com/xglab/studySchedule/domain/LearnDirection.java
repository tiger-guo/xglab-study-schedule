package com.xglab.studySchedule.domain;

import lombok.Data;

import java.util.Date;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-27 21:02
 **/

@Data
public class LearnDirection {

    int id;
    String directionName;
    String directionDetail;
    Date createTime;
    Date modifyTime;
}
