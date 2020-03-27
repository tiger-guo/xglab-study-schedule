package com.xglab.studySchedule.controller;

import cn.hutool.core.util.ObjectUtil;
import com.xglab.studySchedule.domain.LabMember;
import com.xglab.studySchedule.domain.result.CodeMsg;
import com.xglab.studySchedule.domain.result.Result;
import com.xglab.studySchedule.service.LabMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: projectName
 * @description:
 * @author: liuguohu
 * @create: 2020-03-26 18:45
 **/
@Slf4j
@RestController()
@RequestMapping("/member")
public class LabMemberController {

    @Autowired
    LabMemberService labMemberService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<LabMember>> getListMember() {
        Result<List<LabMember>> result;
        List<LabMember> labMembers = labMemberService.getListMember();
        result = Result.success(labMembers);
        return result;
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public Result addMember(@RequestBody LabMember labMember) {
        Result result;
        if(ObjectUtil.isNull(labMember)){
            return Result.error(CodeMsg.PARAM_IS_NULL);
        }
        labMemberService.save(labMember);
        result = Result.success();
        return result;
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public Result updateMember(@RequestBody LabMember labMember) {
        Result result;
        if(ObjectUtil.isNull(labMember)){
            return Result.error(CodeMsg.PARAM_IS_NULL);
        }
        labMemberService.update(labMember);
        result = Result.success();
        return result;
    }

    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    public Result<LabMember> getMemberById(@RequestParam(name = "id", required = true) Integer id) {
        Result result;
        LabMember labMember = labMemberService.findById(id);
        result = Result.success(labMember);
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, String> param) {
        Result result;
        String userName = param.get("userName");
        String password = param.get("password");
        if(ObjectUtil.isNull(userName) && ObjectUtil.isNull(password)){
            return Result.error(CodeMsg.PARAM_IS_NULL);
        }
        Integer userId = labMemberService.loginByNameAndPassword(userName, password);
        // -1 代表用户不存在
        if (userId != -1) {
            result = Result.success(userId);
        } else {
            result = Result.error(CodeMsg.NOT_EXIST_USER);
        }
        return result;
    }
}
