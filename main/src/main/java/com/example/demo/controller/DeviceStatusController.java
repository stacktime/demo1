package com.example.demo.controller;


import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.service.TblDeviceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/status")
public class DeviceStatusController {

    @Autowired
    private TblDeviceInfoService tblDeviceInfoService;
    @PostMapping("/insertStatus")
    public Object insertStatus(@RequestBody TblDeviceInfo tblDeviceInfo) {
        return tblDeviceInfoService.insertStatus(tblDeviceInfo);
    }

    @PutMapping("/deleted")
    public Object deleted(@RequestBody TblDeviceInfo tblDeviceInfo) {
        return tblDeviceInfoService.updateData(tblDeviceInfo);
    }
    @PutMapping("/updateData")
    public Object updateData(@RequestBody TblDeviceInfo tblDeviceInfo) {
        return tblDeviceInfoService.updateData(tblDeviceInfo);
    }
}
