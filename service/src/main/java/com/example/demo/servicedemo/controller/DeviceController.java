package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
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
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/findDeviceById")
    public Object findDeviceById(@RequestParam Integer id) {
        if (null == id) {
            throw new RuntimeException("id不能为空");
        }
        DeviceDO device = deviceService.findDeviceById(id);
        return device;
    }

    @GetMapping("/modifyStatus")
    public Object modifyStatus(@RequestParam Integer id, @RequestParam Integer status) {
        if (null == id || null == status) {
            throw new RuntimeException("id不能为空");
        }
        boolean modifyStatus = deviceService.modifyStatus(id, status);
        return modifyStatus;
    }
}
