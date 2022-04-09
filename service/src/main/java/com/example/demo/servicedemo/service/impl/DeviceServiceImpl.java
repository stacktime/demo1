package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.common.Constant;
import com.example.demo.servicedemo.dao.DeviceDao;
import com.example.demo.servicedemo.module.dto.RequestDTO;
import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author WangYuanbo
 * @date 2022/4/3 14:03
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    /**
     * 插入
     */
    @Override
    public void insertStatus(ResDto resDto) {
        DeviceDO deviceDO;
        Integer deviceId = resDto.getId();
        if (deviceId == null) {
            deviceDO = new DeviceDO();
        }else {
            deviceDO = deviceDao.findByIdAndDeleted(deviceId , resDto.getDeleted());
            if (deviceDO == null) {
                deviceDO = new DeviceDO();
            }
        }
        deviceDO.setCode(resDto.getCode());
        deviceDO.setName(resDto.getName());
        deviceDO.setStatus(resDto.getStatus());
        deviceDO.setDeleted(resDto.getDeleted());
        deviceDO.setGmtCreate(Constant.Time);
        deviceDO.setCreateUser(resDto.getCreateUser());
        deviceDO.setGmtModify(Constant.Time);
        deviceDO.setModifyUser(resDto.getModifyUser());
        deviceDao.saveAndFlush(deviceDO);
    }

    /**
     * 查找
     */
    @Override
    public DeviceDO findDeviceById(ResDto resDto) {
        DeviceDO dDo = deviceDao.findByIdAndDeleted(resDto.getId(), resDto.getDeleted());
        if (dDo == null){
            throw new RuntimeException("查找失败");
        }
        return dDo;
    }

    /**
     * 更新
     */
    @Override
    public void updateData(ResDto resDto) {
        DeviceDO dDo;
        Integer deviceId = resDto.getId();
        Integer deviceDeleted = resDto.getDeleted();
        dDo = deviceDao.findByIdAndDeleted(deviceId , deviceDeleted);
        if(dDo == null) {
            throw new RuntimeException("该设备已经被删除:");
        }else {
            Integer deviceStatus = resDto.getStatus();
            deviceDao.updateStatusById(deviceStatus , deviceId , deviceDeleted);
        }
    }

    /**
     * 删除
     */
    @Override
    public void deleteData(ResDto resDto) {
        deviceDao.deleteById(resDto.getId());
    }


/**
    @Autowired
    private DeviceDao deviceDao;


    @Override
    public DeviceDO findDeviceById(Integer id) {
        DeviceDO aDo = deviceDao.findByIdAndDeleted(id, Constant.NO);
        if (null == aDo) {
            throw new RuntimeException(id + "执行了,但是失败了");
        }
        return aDo;
    }

    @Override
    public void insertStatus(String code, String name) {
        DeviceDO deviceDO = new DeviceDO();
        //Date date = new Date();
        deviceDO.setCode(code);
        deviceDO.setName(name);
        deviceDO.setStatus(0);
        deviceDO.setDeleted(0);
        deviceDO.setGmtCreate(new Date());//插入当前时间
        deviceDO.setGmtModify(new Date());

        deviceDao.saveAndFlush(deviceDO);
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


    @Override
    public Integer saveDevice(RequestDTO requestDTO) {
        DeviceDO deviceDO;
        Integer deviceId = requestDTO.getId();
        if (null == deviceId) {
            deviceDO = new DeviceDO();
        } else {
            deviceDO = deviceDao.findByIdAndDeleted(deviceId, Constant.NO);
            if (null == deviceDO) {
                deviceDO = new DeviceDO();
            }
        }
        deviceDO.setCode(requestDTO.getCode());
        deviceDO.setName(requestDTO.getName());
        deviceDO.setStatus(requestDTO.getStatus());
        DeviceDO save = deviceDao.save(deviceDO);
        return save.getId();
    }
 */

}
