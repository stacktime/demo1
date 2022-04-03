package com.example.demo.servicedemo.service;

import com.example.demo.servicedemo.module.entity.DeviceDO;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:01
 */
public interface DeviceService {

    /**
     * 测试方法
     */
    DeviceDO findDeviceById(Integer id);
}
