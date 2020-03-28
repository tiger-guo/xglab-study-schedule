package com.xglab.studySchedule.controller;

import com.xglab.studySchedule.domain.LearnDirection;
import com.xglab.studySchedule.domain.result.Result;
import com.xglab.studySchedule.service.LabMemberService;
import com.xglab.studySchedule.service.LearnDirectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    LearnDirectionService learnDirectionService;

    /**
     * 给成员设置学习方向
     * @param param
     * @return
     */
    @RequestMapping(value = "/choose", method = RequestMethod.PUT)
    public Result chooseDirection(@RequestBody Map<String, Integer> param) {
        Integer userId = param.get("userId");
        Integer did = param.get("did");

        labMemberService.chooseDirection(userId, did);

        return Result.success();
    }

    /**
     * 获取学习方向列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result getListLearnDirection(){
        List<LearnDirection> learnDirections = learnDirectionService.list();
        return Result.success(learnDirections);
    }


    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public Result getOneLearnDirection(@RequestParam(value = "id", required = true) Integer id){
        LearnDirection learnDirection = learnDirectionService.findById(id);
        return Result.success(learnDirection);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addLearnDirection(@RequestBody LearnDirection learnDirection){
        Integer learnDirectionId = learnDirectionService.save(learnDirection);
        return Result.success(learnDirectionId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result updateLearnDirection(@RequestBody LearnDirection learnDirection){
        learnDirectionService.update(learnDirection);
        return Result.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteLearnDirection(@RequestParam(value = "id", required = true) Integer id){
        learnDirectionService.delete(id);
        return Result.success();
    }
}
