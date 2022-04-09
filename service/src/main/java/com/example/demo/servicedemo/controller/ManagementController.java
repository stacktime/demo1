package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.service.DeviceManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/upAndDown")
    public void upAndDown(@RequestBody ResDto resDto) {
        deviceManagement.upAndDown(resDto);
    }

    @PostMapping("/enableAndDisable")
    public void enableAndDisable(@RequestBody ResDto resDto){
        deviceManagement.enableAndDisable(resDto);
    }

    @PostMapping("/deletedProduct")
    public void deletedProduct(@RequestBody ResDto resDto) {deviceManagement.deletedProduct(resDto);}
}
