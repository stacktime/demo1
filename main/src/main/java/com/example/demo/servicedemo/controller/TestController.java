package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.module.entity.IotEquipmentStatusDO;
import com.example.demo.servicedemo.service.IotEquipmentStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYuanbo
 * @date 2022/5/4 12:53
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private IotEquipmentStatusService iotEquipmentStatusService;

    @GetMapping("/findById")
    public Object findById(@RequestParam Integer id) {
        if (null == id) {
            throw new RuntimeException("id不能为空");
        }
        IotEquipmentStatusDO primaryKey = iotEquipmentStatusService.selectByPrimaryKey(id);
        return primaryKey;
    }
}
