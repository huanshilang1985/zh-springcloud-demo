package com.zh.user.controller;

import com.zh.common.OpResult;
import com.zh.user.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author he.zhang
 * @date 2020/3/15 9:45
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("getUser")
    @ResponseBody
    public OpResult<UserInfo> getUser(){
        return OpResult.getSuccResultData(new UserInfo(1, "Tom"));
    }

}
