package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.dao.DeviceDao;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:03
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private DeviceDao deviceDao;

    /**
     * 测试方法
     */
    @Override
    public String doService(String str) {
        Optional<DeviceDO> optional = deviceDao.findById(1);
        if (!optional.isPresent()) {
            throw new RuntimeException(str + "执行了,但是失败了");
        }
        DeviceDO deviceDO = optional.get();
        return str + "执行了" + deviceDO.getName();
    }
}
