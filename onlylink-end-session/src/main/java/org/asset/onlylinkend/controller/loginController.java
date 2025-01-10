package org.asset.onlylinkend.controller;

import jakarta.annotation.Resource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.asset.onlylinkend.services.UserInfoService;
import org.asset.onlylinkend.utils.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.asset.onlylinkend.entity.vo.ResponseVO;
import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.services.UserService;
import org.asset.onlylinkend.controller.Base.BaseController;
import org.asset.onlylinkend.entity.constant.Constants;
import org.asset.onlylinkend.entity.dto.userInfo;

import java.util.Objects;

@RestController
public class loginController {
    @Resource
    private user user;
    @Resource
    private UserService UserService;
    @Resource
    private UserInfoService UserInfoService;
    @Resource
    private userInfo userInfo;


//    @Resource
//    private HttpSession httpSession;


    /**
     * register
     *
     * @param
     */


    @RequestMapping("/register")
    public ResponseVO register(String username, String email, String password) {
        user = UserService.findByUsername(username);
        ResponseVO responseVO = new ResponseVO();
        if (user == null && Valid.isEmail(email) && Valid.isNickname(username) && Valid.isPassword(password) && UserService.findByEmail(email) == null) {
            UserService.insertUser(username, password, email);
            responseVO.setStatus("success");
            responseVO.setCode(200);
            responseVO.setInfo("注册成功");
        } else if (user != null) {
            responseVO.setStatus("error");
            responseVO.setCode(400);
            responseVO.setInfo("用户名已被使用");
        } else if (UserService.findByEmail(email) != null) {
            responseVO.setStatus("error");
            responseVO.setCode(400);
            responseVO.setInfo("邮箱已存在");
        } else {
            responseVO.setStatus("error");
            responseVO.setCode(401);
            responseVO.setInfo("请输入格式符合要求的信息");
        }
        return responseVO;
    }

    /**
     * login
     *
     * @param
     */
    @RequestMapping("/login")
    public ResponseVO login(HttpSession session, String username, String password) {
        ResponseVO responseVO = new ResponseVO();
        if (Objects.equals(UserService.findByUsername(username).getPassword(), password)) {
            user = UserService.findByUsername(username);
            userInfo = UserInfoService.findUserInfoByUsername(username);
            responseVO.setStatus(Constants.STATUC_SUCCESS);
            responseVO.setCode(200);
            responseVO.setInfo("登录成功");
            session.setAttribute(Constants.SESSION_KEY, userInfo);// sucess将用户信息save到session中
        } else {
            responseVO.setStatus(Constants.STATUC_ERROR);
            responseVO.setCode(400);
            responseVO.setInfo("用户名或者密码错误");
        }
        return responseVO;

    }

    /**
     * login out
     */
    @RequestMapping("/loginout")
    public ResponseVO loginout(HttpSession session) {
        session.invalidate();
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus("success");
        responseVO.setCode(200);
        responseVO.setInfo("退出成功");
        return responseVO;
    }


    // lao luo
    @GetMapping("/userInfo")
    public ResponseVO getUserInfo(HttpSession session) {
//        HttpSession session = request.getSession(); // if no session will create one
        ResponseVO responseVO = new ResponseVO();
        BaseController baseController = new BaseController();
        userInfo sessionWebUserDto = baseController.getUserInfoFromSession(session);
        if (sessionWebUserDto == null) {
            session.invalidate();
            responseVO.setStatus(Constants.STATUC_ERROR);
            responseVO.setCode(400);
            responseVO.setInfo("用户未登录");
        } else {
            responseVO.setStatus(Constants.STATUC_SUCCESS);
            responseVO.setCode(200);
            responseVO.setInfo(Constants.STATUC_SUCCESS);
            responseVO.setData(sessionWebUserDto);
        }
        return responseVO;
    }


}
