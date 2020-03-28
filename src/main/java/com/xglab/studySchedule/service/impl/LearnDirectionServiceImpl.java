package com.xglab.studySchedule.service.impl;

import com.xglab.studySchedule.dao.LearnDirectionMapper;
import com.xglab.studySchedule.domain.LearnDirection;
import com.xglab.studySchedule.service.LearnDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-27 21:06
 **/
@Service
public class LearnDirectionServiceImpl extends BaseServiceImpl<LearnDirection> implements LearnDirectionService {

    @Autowired
    LearnDirectionMapper learnDirectionMapper;
}
