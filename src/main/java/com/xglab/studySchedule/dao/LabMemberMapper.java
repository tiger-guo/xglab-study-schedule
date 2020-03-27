package com.xglab.studySchedule.dao;

import com.xglab.studySchedule.domain.LabMember;
import com.xglab.studySchedule.domain.query.LabMemberQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:58
 **/
@Mapper
public interface LabMemberMapper extends BaseMapper<LabMember>{

    List<LabMember> getListMember();


    Integer loginByNameAndPassword(LabMemberQuery query);

    void chooseDirection(Integer userId, Integer did);
}
