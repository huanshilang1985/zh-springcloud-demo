package com.zh.user.controller;

import com.zh.common.Constant;
import com.zh.common.OpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User的Rest请求专用Controller
 *
 * @author he.zhang
 * @date 2020/3/14 22:49
 */
@RequestMapping("/rest")
@RestController
public class UserRestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getPower")
    @ResponseBody
    public OpResult getPower(){
        // 第一个参数是请求的URL, 第二个参数 返回值类型，如果需要参数，放到第三个参数
        // Constant.POWER_URL是注册到eureka上的power项目服务名
        // eureka只负责服务注册，服务之间的调用是ribbon
        return restTemplate.getForObject(Constant.POWER_URL + "/getPower", OpResult.class);
    }

}
