package com.zh.user.controller;

import com.zh.common.OpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author he.zhang
 * @date 2020/3/15 20:12
 */
@RestController
public class PowerController {

    @RequestMapping("getPower")
    public OpResult getPower(){
        Map<String, String> map = new HashMap<>();
        map.put("key", "power1");
        return OpResult.getSuccResultData(map);
    }

}
