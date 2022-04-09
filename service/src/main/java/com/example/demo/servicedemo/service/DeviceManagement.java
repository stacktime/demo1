package com.example.demo.servicedemo.service;

import com.example.demo.servicedemo.module.dto.ResDto;

public interface DeviceManagement {
    /**
     * 创建设备
     * @return
     */
    Integer createDevice(ResDto resDto);
    /**
     * 创建产品
     */
    Integer createProduct(ResDto resDto);
    /**
     * 上下线
     */
    Integer upAndDown(ResDto resDto);
    /**
     * 启用和禁用
     */
    Integer enableAndDisable(ResDto resDto);
    /**
     * 删除设备
     */

    Integer deletedProduct(ResDto resDto);
}
