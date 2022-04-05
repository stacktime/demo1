package com.example.demo.servicedemo.controller;

import com.example.demo.servicedemo.module.dto.RequestDTO;
import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/insertStatus")
    public void insertStatus(@RequestParam ResDto resDto) {
        deviceService.insertStatus(resDto);
    }

    @GetMapping("/findDeviceByid")
    public DeviceDO findDeviceById(@RequestParam ResDto resDto) {
        if (null == resDto.getId()) {
            throw new RuntimeException("id不能为空");
        }
        DeviceDO device = deviceService.findDeviceById(resDto);
        return device;
    }

    @GetMapping("/updateData")
    public void updateData(@RequestParam ResDto resDto) {
        deviceService.updateData(resDto);
    }

    @GetMapping("/deleteData")
    public void deleteData(@RequestParam ResDto resDto) {
        deviceService.deleteData(resDto);
    }


/**
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

    @GetMapping("/insertStatus")
    public Object insertStatus(@RequestParam String code, String name) {
        deviceService.insertStatus(code, name);
        return 0;
    }

    @PostMapping("/saveDevice")
    public Object saveDevice(@RequestBody RequestDTO request) {
        if (null == request) {
            throw new RuntimeException("请求参数不能为空");
        }
        Integer deviceId = deviceService.saveDevice(request);
        return deviceId;
    }
*/

}
