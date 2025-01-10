package org.asset.onlylinkend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.asset.onlylinkend.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.services.UserService;
import org.asset.onlylinkend.entity.vo.ResponseVO;
import org.asset.onlylinkend.entity.constant.Constants;
import org.asset.onlylinkend.services.UserInfoService;
import org.asset.onlylinkend.entity.dto.userInfo;

@RestController
public class testController {

    @Resource
    private UserService UserService;
    @Resource
    private user user;

    @Resource
    private userInfo userInfo;
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/SessionTest")
    public ResponseVO SessionTest(HttpSession session, String Msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(Constants.STATUC_SUCCESS);
        responseVO.setCode(200);
        responseVO.setInfo("登录成功" + "登录口令是" + Msg);
        responseVO.setData(session.getId());
        return responseVO;
    }


    @RequestMapping("/getByUsername")
    public ResponseVO GetEmail(String username) {
        user = UserService.findByUsername(username);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(Constants.STATUC_SUCCESS);
        responseVO.setCode(200);
        responseVO.setInfo(Constants.STATUC_SUCCESS);
        responseVO.setData(user);
        return responseVO;
    }


// error api
    @RequestMapping("/getByEmail")
    public ResponseVO GetUsername(String email) {
        user = UserService.findByEmail(email);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(Constants.STATUC_SUCCESS);
        responseVO.setCode(200);
        responseVO.setInfo(Constants.STATUC_SUCCESS);
        responseVO.setData(user);
        return responseVO;
    }

    @RequestMapping("/getUserinfoByUsername")
    public ResponseVO GetUserinfoByUsername(String username) {
        userInfo =userInfoService.findUserInfoByUsername(username);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(Constants.STATUC_SUCCESS);
        responseVO.setCode(200);
        responseVO.setInfo(Constants.STATUC_SUCCESS);
        responseVO.setData(userInfo);
        return responseVO;
    }



}
