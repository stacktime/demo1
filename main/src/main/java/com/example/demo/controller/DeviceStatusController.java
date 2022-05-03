package com.example.demo.controller;


import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.service.TblDeviceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/Status")
public class DeviceStatusController {

    @Autowired
    private TblDeviceInfoService tblDeviceInfoService;

    @PostMapping("/insertStatus")
    public Object insertStatus(@RequestBody TblDeviceInfo tblDeviceInfo) {
        tblDeviceInfoService.insertStatus(tblDeviceInfo);
        return 1;
    }
    @PostMapping("/deleted")
    public Object deleted(@RequestBody TblDeviceInfo tblDeviceInfo) {
        tblDeviceInfoService.updateById(tblDeviceInfo);
        return 1;
    }
    @PostMapping("/updateData")
    public Object updateData(@RequestBody TblDeviceInfo tblDeviceInfo) {
        tblDeviceInfoService.updateData(tblDeviceInfo);
        return 1;
    }
}
