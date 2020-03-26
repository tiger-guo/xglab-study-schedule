package com.xglab.studySchedule.service;

import com.xglab.studySchedule.domain.LabMember;

import java.util.List;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:56
 **/

public interface LabMemberService  extends IBaseService<LabMember>{

    List<LabMember> getListMember();

}
