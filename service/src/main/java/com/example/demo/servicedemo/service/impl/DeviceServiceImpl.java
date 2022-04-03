package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.dao.DeviceDao;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:03
 */
@Service
public class DeviceServiceImpl implements DeviceService {


    @Autowired
    private DeviceDao deviceDao;

    /**
     * 测试方法
     */
    @Override
    public DeviceDO findDeviceById(Integer id) {
        Optional<DeviceDO> optional = deviceDao.findById(1);
        if (!optional.isPresent()) {
            throw new RuntimeException(id + "执行了,但是失败了");
        }
        DeviceDO deviceDO = optional.get();
        return deviceDO;
    }
}
