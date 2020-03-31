package com.zh.user.controller;

import com.zh.common.OpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Power的Rest请求专用Controller
 *
 * @author he.zhang
 * @date 2020/3/14 22:49
 */
@RestController
@RequestMapping("rest")
public class PowerRestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用RestTemplate请求远程地址
     * @return OpResult
     */
    @RequestMapping("getUser")
    @ResponseBody
    public OpResult getUser(){
        //  第一个参数是请求的URL, 第二个参数 返回值类型，如果需要参数，放到第三个参数
        return restTemplate.getForObject("http://localhost:5002/user/getUser", OpResult.class);
    }


}
