package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.entity.DeviceDO2;


/**
 * @author 14266
 * @description 针对表【tbl_device_info】的数据库操作Service
 * @createDate 2022-05-04 00:20:01
 */
public interface TblDeviceInfoService extends IService<DeviceDO2> {

    public Integer insertStatus(TblDeviceInfo tblDeviceInfo);

    public String deleted(TblDeviceInfo tblDeviceInfo);

    public Integer updateData(TblDeviceInfo tblDeviceInfo);

    public Integer selectName(TblDeviceInfo tblDeviceInfo);


}
