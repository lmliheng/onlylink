package org.asset.onlylinkend.controller;

import jakarta.annotation.Resource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.asset.onlylinkend.utils.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.asset.onlylinkend.entity.vo.ResponseVO;
import org.asset.onlylinkend.entity.dto.user;
import org.asset.onlylinkend.services.UserService;
import org.asset.onlylinkend.controller.Base.BaseController;
import org.asset.onlylinkend.entity.constant.Constants;

import java.util.Objects;

@RestController
public class loginController {
    @Resource
    private user user;
    @Resource
    private UserService UserService;


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

    /**
     * register
     *
     * @param session
     */


    @RequestMapping("/register")
    public ResponseVO register(HttpSession session, String Email, String NickName, String Password) {
        user = UserService.findByUsername(NickName);

        ResponseVO responseVO = new ResponseVO();
        if (user == null && Valid.isEmail(Email) && Valid.isNickname(NickName) && Valid.isPassword(Password) && UserService.findByEmail(Email) == null) {

//            try{
//                UserService.insertUser(NickName, Password, Email);
//            }catch (SQLIntegrityConstraintViolationException e){
//
//            } 需要检查邮箱的一致性

            UserService.insertUser(NickName, Password, Email);
            responseVO.setStatus("success");
            responseVO.setCode(200);
            responseVO.setInfo("注册成功");
            responseVO.setData(session.getId());

        } else if (user != null) {
            responseVO.setStatus("error");
            responseVO.setCode(400);
            responseVO.setInfo("用户名已被使用");
            responseVO.setData(session.getId());

        } else if (UserService.findByEmail(Email) != null) {
            responseVO.setStatus("error");
            responseVO.setCode(400);
            responseVO.setInfo("邮箱已存在");
            responseVO.setData(session.getId());

        } else {
            responseVO.setStatus("error");
            responseVO.setCode(401);
            responseVO.setInfo("请输入格式符合要求的信息");
            responseVO.setData(session.getId());

        }

        return responseVO;
    }


//        if ((Valid.isEmail(Email) && Valid.isNickname(NickName) && Valid.isPassword(Password) != true)) {
//            responseVO.setStatus("error");
//            responseVO.setCode(400);
//            responseVO.setInfo("请输入格式符合要求的信息");
//            responseVO.setData(session.getId());
//            return responseVO;
//        }
//
//        try {
//            if (user.getUsername() != null && user.getEmail() != null) {
//                responseVO.setStatus("error");
//                responseVO.setCode(400);
//                responseVO.setInfo("用户已存在");
//                responseVO.setData(session.getId());
//                return responseVO;
//            }
//        }catch (NullPointerException e){
//            responseVO.setStatus("error");
//            responseVO.setCode(400);
//            responseVO.setInfo("用户已存在");
//            responseVO.setData(session.getId());
//            return responseVO;
//        }
//
//        return responseVO;
//    }


    /**
     * login
     *
     * @param
     */
    @RequestMapping("/login")
    public ResponseVO login(HttpSession session, HttpServletRequest request, String username, String password) {
        ResponseVO responseVO = new ResponseVO();
        if (Objects.equals(UserService.findByUsername(username).getPassword(), password)  ) {
            user = UserService.findByUsername(username);
            responseVO.setStatus("success");
            responseVO.setCode(200);
            responseVO.setInfo("登录成功");
            responseVO.setData(UserService.findByUsername(username).getPassword());

            session.setAttribute(Constants.SESSION_KEY, user);// sucess将用户信息save到session中

        } else {
            responseVO.setStatus("false");
            responseVO.setCode(400);
            responseVO.setInfo("用户名或者密码错误");
            responseVO.setData(UserService.findByUsername(username).getPassword());
        }
        return responseVO;

    }

    /**
     * login out
     */
    @RequestMapping("/loginout")
    public ResponseVO loginout(HttpSession session) {
        ResponseVO responseVO = new ResponseVO();
        session.invalidate();
        responseVO.setStatus("success");
        responseVO.setCode(200);
        responseVO.setInfo("退出成功");
        responseVO.setData(session.getId());
        return responseVO;
    }



// lao luo
    @GetMapping("/userInfo")
    public ResponseVO getUserInfo(HttpServletRequest request) {

        HttpSession session = request.getSession();
        BaseController baseController = new BaseController();
        user sessionWebUserDto = baseController.getUserInfoFromSession(session);
//        ResponseVO responseVO = new ResponseVO();
//        responseVO.setStatus("success");
//        responseVO.setCode(200);
//        responseVO.setInfo("获取成功");
//        responseVO.setData(sessionWebUserDto);
//        return responseVO;

        return baseController.getSuccessResponseVO(sessionWebUserDto);
    }




}
