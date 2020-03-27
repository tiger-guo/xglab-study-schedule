package com.xglab.studySchedule.controller;

import com.xglab.studySchedule.domain.result.Result;
import com.xglab.studySchedule.service.LabMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-27 20:03
 **/

@Slf4j
@RestController()
@RequestMapping("/direction")
public class LearnDirectionController {

    @Autowired
    LabMemberService labMemberService;

    @RequestMapping(value = "/choose", method = RequestMethod.PUT)
    public Result chooseDirection(@RequestBody Map<String, Integer> param) {
        Integer userId = param.get("userId");
        Integer did = param.get("did");

        labMemberService.chooseDirection(userId, did);

        return Result.success();
    }
}
