package com.example.demo.servicedemo.service;

import com.example.demo.servicedemo.module.entity.IotEquipmentStatusDO;

/**
 * @author WangYuanbo
 * @date 2022/5/4 12:52
 */
public interface IotEquipmentStatusService {


    int insert(IotEquipmentStatusDO record);

    int insertSelective(IotEquipmentStatusDO record);

    IotEquipmentStatusDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotEquipmentStatusDO record);

    int updateByPrimaryKey(IotEquipmentStatusDO record);

}
