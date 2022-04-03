package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:10
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testDo")
    public Object testDo(@RequestParam String name, @RequestParam String name2) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("姓名不能为空");
        }
        String s = testService.doService(name);
        log.info("请求参数:{},响应参数:{}", name, s);
        return s + name2;
    }
}
