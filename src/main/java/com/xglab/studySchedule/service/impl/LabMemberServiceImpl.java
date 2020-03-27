package com.xglab.studySchedule.service.impl;

import com.xglab.studySchedule.dao.LabMemberMapper;
import com.xglab.studySchedule.domain.LabMember;
import com.xglab.studySchedule.domain.User;
import com.xglab.studySchedule.domain.query.LabMemberQuery;
import com.xglab.studySchedule.service.LabMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:57
 **/
@Service
public class LabMemberServiceImpl extends BaseServiceImpl<LabMember> implements LabMemberService {

    @Autowired
    LabMemberMapper labMemberMapper;

    @Override
    public List<LabMember> getListMember() {

        return labMemberMapper.getListMember();
    }

    @Override
    public Integer loginByNameAndPassword(String userName, String password) {
        LabMemberQuery query = new LabMemberQuery();
        query.setUserName(userName);
        query.setPassword(password);
        Integer id = labMemberMapper.loginByNameAndPassword(query);
        if(id == null){
            id = -1;
        }
        return id;
    }
}
