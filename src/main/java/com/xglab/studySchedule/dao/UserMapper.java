package com.xglab.studySchedule.dao;

import com.xglab.studySchedule.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-07 23:05
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
