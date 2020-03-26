package com.xglab.studySchedule.controller;

import com.xglab.studySchedule.domain.LabMember;
import com.xglab.studySchedule.domain.vo.Result;
import com.xglab.studySchedule.service.LabMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        try {
            List<LabMember> labMembers = labMemberService.getListMember();
            result = new Result<>(200, "OK", labMembers);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(500,"获取实验室成员出错！");
        }
        return result;
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public Result addMember(LabMember labMember){
        Result result;

        try {
            labMemberService.save(labMember);
            return new Result(200, "OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"添加实验室成员出错");
        }
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public Result updateMember(LabMember labMember){
        Result result;

        try {
            labMemberService.update(labMember);
            return new Result(200, "OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"修改实验室成员信息出错");
        }
    }

    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    public Result<LabMember> getMemberById(Integer id){
        Result result;

        try {
            LabMember labMember = labMemberService.findById(id);
            return new Result(200, "OK", labMember);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"获取实验室成员信息出错");
        }
    }
}
