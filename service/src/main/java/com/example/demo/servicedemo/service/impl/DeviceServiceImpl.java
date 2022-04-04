package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.common.Constant;
import com.example.demo.servicedemo.dao.DeviceDao;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        DeviceDO aDo = deviceDao.findByIdAndDeleted(id, Constant.NO_BYTE);
        if (null == aDo) {
            throw new RuntimeException(id + "执行了,但是失败了");
        }
        return aDo;
    }

    @Override
    public boolean modifyStatus(Integer id, Integer status) {
        try {
            deviceDao.updateStatusById(id, status);
        } catch (Exception e) {
            // 报错就返回false 说明更改失败
            return false;
        }
        // 没报错就返回true 说明更改成功
        return true;
    }
}
