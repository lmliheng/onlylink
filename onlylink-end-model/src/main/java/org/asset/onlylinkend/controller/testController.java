package org.asset.onlylinkend.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.services.UserService;
import org.asset.onlylinkend.entity.vo.ResponseVO;


@RestController
public class testController {

    @Resource
    private UserService UserService;
    @Resource
    private user user;


    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/SessionTest")
    public ResponseVO SessionTest(HttpSession session, String Msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus("success");
        responseVO.setCode(200);
        responseVO.setInfo("登录成功" + "登录口令是" + Msg);
        responseVO.setData(session.getId());
        return responseVO;
    }
    @RequestMapping("/getEmail")
    public ResponseVO GetEmail( String username) {
        user = UserService.findByUsername(username);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus("success");
        responseVO.setCode(200);
        responseVO.setInfo("获取成功" + "，登录邮箱是" + user.getEmail() + "，登录id是" + user.getId());

        return responseVO;
    }
    @RequestMapping("/getUsername")
    public ResponseVO GetUsername( String email) {
        user = UserService.findByEmail(email);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus("success");
        responseVO.setCode(200);
        responseVO.setInfo("获取成功" + "，登录名是" + user.getUsername() + "，登录id是" + user.getId());

        return responseVO;
    }



}
