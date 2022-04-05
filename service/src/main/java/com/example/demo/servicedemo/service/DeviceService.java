package com.example.demo.servicedemo.service;

import com.example.demo.servicedemo.module.dto.RequestDTO;
import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.module.entity.DeviceDO;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:01
 */
public interface DeviceService {
    /**
     * 测试方法
     */
    /**
     DeviceDO findDeviceById(Integer id);

    boolean modifyStatus(Integer id, Integer status);

    void insertStatus(String code, String name);


    Integer saveDevice(RequestDTO requestDTO);
    */
    /**
     * 插入
     */
    void insertStatus(ResDto resDto);

    /**
     * 查找
     */
    DeviceDO findDeviceById(ResDto resDto);

    /**
     * 更新
     */
    void updateData(ResDto resDto);

    /**
     * 删除
     */

    void deleteData(ResDto resDto);

}
