package com.example.demo.service.impl;

import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:03
 */
@Service
public class TestServiceImpl implements TestService {

    /**
     * 测试方法
     */
    @Override
    public String testDo(String str) {
        System.out.println("测试执行了: " + str);
        return str + "执行了";
    }
}
