package com.xglab.studySchedule.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.sql.Direction;
import com.xglab.studySchedule.domain.LabMember;
import com.xglab.studySchedule.domain.LearnDirection;
import com.xglab.studySchedule.domain.enumUtil.MemberStateEnum;
import com.xglab.studySchedule.domain.result.CodeMsg;
import com.xglab.studySchedule.domain.result.Result;
import com.xglab.studySchedule.domain.vo.LabMemberVO;
import com.xglab.studySchedule.service.LabMemberService;
import com.xglab.studySchedule.service.LearnDirectionService;
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

    @Autowired
    LearnDirectionService learnDirectionService;

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
    public Result<LabMemberVO> getMemberById(@RequestParam(name = "id", required = true) Integer id) {
        Result result;
        LabMemberVO labMemberVO = new LabMemberVO();
        // 查询个人信息
        LabMember labMember = labMemberService.findById(id);
        BeanUtil.copyProperties(labMember, labMemberVO);

        // 设置当前成员状态
        for(MemberStateEnum stateEnum : MemberStateEnum.values()){
            if(stateEnum.getType() == labMember.getState()){
                labMemberVO.setStateType(stateEnum.getDescribe());
                break;
            }
        }
        // 查询当前成员选择方向
        LearnDirection direction = learnDirectionService.findById(labMember.getDid());
        if(direction == null){
            labMemberVO.setDirection("没有选择方向！");
        }else {
            labMemberVO.setDirection(direction.getDirectionName());
        }
        result = Result.success(labMemberVO);
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
