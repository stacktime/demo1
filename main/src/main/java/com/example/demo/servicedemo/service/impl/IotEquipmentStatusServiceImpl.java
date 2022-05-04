package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.mapper.IotEquipmentStatusMapper;
import com.example.demo.servicedemo.module.entity.IotEquipmentStatusDO;
import com.example.demo.servicedemo.service.IotEquipmentStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author WangYuanbo
 * @date 2022/5/4 12:52
 */
@Service
public class IotEquipmentStatusServiceImpl implements IotEquipmentStatusService {

    @Resource
    private IotEquipmentStatusMapper iotEquipmentStatusMapper;

    @Override
    public int insert(IotEquipmentStatusDO record) {
        return iotEquipmentStatusMapper.insert(record);
    }

    @Override
    public int insertSelective(IotEquipmentStatusDO record) {
        return iotEquipmentStatusMapper.insertSelective(record);
    }

    @Override
    public IotEquipmentStatusDO selectByPrimaryKey(Integer id) {
        return iotEquipmentStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IotEquipmentStatusDO record) {
        return iotEquipmentStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IotEquipmentStatusDO record) {
        return iotEquipmentStatusMapper.updateByPrimaryKey(record);
    }

}
