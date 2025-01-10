package org.asset.onlylinkend.controller.Api;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.asset.onlylinkend.entity.dto.userInfo;
import org.asset.onlylinkend.services.UserInfoService;
import org.asset.onlylinkend.entity.vo.ResponseVO;
import org.asset.onlylinkend.entity.constant.Constants;


@RestController
@RequestMapping("user")
public class userController {

    @Resource
    private userInfo userInfo;
    @Resource
    private UserInfoService userInfoService;


    @GetMapping("/{username}")
    public ResponseVO getUserInfo(@PathVariable String username){
        ResponseVO responseVO = new ResponseVO();
        userInfo userInfo = userInfoService.findUserInfoByUsername(username);
        if (userInfo == null) {
            responseVO.setStatus(Constants.STATUC_ERROR);
            responseVO.setCode(400);
            responseVO.setInfo("用户不存在");
        } else {
            responseVO.setStatus(Constants.STATUC_SUCCESS);
            responseVO.setCode(200);
            responseVO.setInfo(Constants.STATUC_SUCCESS);
            responseVO.setData(userInfo);
        }

        return responseVO;
    }


}
