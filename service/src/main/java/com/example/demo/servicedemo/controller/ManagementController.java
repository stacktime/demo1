package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.service.DeviceManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class ManagementController {

    @Autowired
    private DeviceManagement deviceManagement;

    @PostMapping("/createDevice")
    public void createDevice(@RequestBody ResDto resDto) {
        deviceManagement.createDevice(resDto);
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody ResDto resDto) {
        deviceManagement.createProduct(resDto);
    }

    /**
     * 更改(更新)状态用 PUT
     *
     * @param resDto
     */
    @PutMapping("/upAndDown")
    public void upAndDown(@RequestBody ResDto resDto) {// 参数不需要用body 一般一个接口就(负责)更新单个状态,前端之需要一个参数就行
        deviceManagement.upAndDown(resDto);
    }

    // TODO 同上
    @PostMapping("/enableAndDisable")
    public void enableAndDisable(@RequestBody ResDto resDto) {
        deviceManagement.enableAndDisable(resDto);
    }

    /**
     * 删除用 DELETE
     *
     * @param resDto
     */
    @DeleteMapping("/deletedProduct")
    public void deletedProduct(@RequestBody ResDto resDto) {
        deviceManagement.deletedProduct(resDto);
    } //  传入主键就行(唯一)
}
