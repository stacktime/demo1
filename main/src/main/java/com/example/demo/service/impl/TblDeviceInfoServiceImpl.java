package com.example.demo.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Const;
import com.example.demo.common.StatusEnum;
import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.entity.DeviceDO2;
import com.example.demo.mapper.TblDeviceInfoMapper;
import com.example.demo.service.TblDeviceInfoService;
import com.example.demo.servicedemo.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author 14266
 * @description 针对表【tbl_device_info】的数据库操作Service实现
 * @createDate 2022-05-04 00:20:01
 */
@Service
public class TblDeviceInfoServiceImpl extends ServiceImpl<TblDeviceInfoMapper, DeviceDO2> implements TblDeviceInfoService {
    @Autowired
    private TblDeviceInfoMapper tblDeviceInfoMapper;

    /**
     * 返回值是否正确
     * <p>
     * 一般接口需要用到多线程不
     * devicedId每个方法都要用到可不可以写在外边
     * 除了添加操作其他操作是否需要验证表中是否存在数据
     * throw new RuntimeException(deviceId + "已存在");是返回给前端页面还是
     *
     * @param tblDeviceInfo
     * @return
     */
    @Override
    public Integer insertStatus(TblDeviceInfo tblDeviceInfo) {
        DeviceDO2 deviceDO2;
        Integer deviceId = tblDeviceInfo.getId();

            deviceDO2 = new DeviceDO2();
            deviceDO2.setId(tblDeviceInfo.getId());
            deviceDO2.setCode(tblDeviceInfo.getCode());
            deviceDO2.setName(tblDeviceInfo.getName());
            deviceDO2.setStatus(tblDeviceInfo.getStatus());
            deviceDO2.setDeleted(Const.DISDELETED);
            deviceDO2.setGmtCreate(new Date());
            deviceDO2.setCreateUser(tblDeviceInfo.getCreateUser());
            deviceDO2.setGmtModify(new Date());
            deviceDO2.setModifyUser(tblDeviceInfo.getModifyUser());
            StatusEnum.EnumByValue(tblDeviceInfo.getStatus());
            try {
            tblDeviceInfoMapper.insert(deviceDO2);
            return tblDeviceInfo.getId();//这个获取到的是插入后的id吗
        }catch (Exception e){
            throw new RuntimeException(deviceId + "已存在");
        }






    }

    @Override
    public String deleted(TblDeviceInfo tblDeviceInfo) {
        DeviceDO2 deviceDO2;
        Integer deviceId = tblDeviceInfo.getId();
        deviceDO2 = tblDeviceInfoMapper.findById(deviceId);//这句是否必要？
        if (deviceDO2 == null || Const.DELETED.equals(tblDeviceInfo.getDeleted())) {

            return "该设备不存在或已被删除";
        } else {
            try {
                tblDeviceInfoMapper.deleteById(deviceId);
                /**
                 * 会不会因为网络原因删除失败但是返回值成功
                 */
                return "删除成功";
            } catch (Exception e) {
                e.printStackTrace();
                return "删除错误";
            }

        }

    }

    @Override
    public Integer updateData(TblDeviceInfo tblDeviceInfo) {
        if (Const.DELETED.equals(tblDeviceInfo.getDeleted()) || tblDeviceInfo.getId() == null) {
            /**
             * 该设备不存在
             */
            return tblDeviceInfo.getId();
        } else {
            tblDeviceInfoMapper.updateById(tblDeviceInfo.getId(), tblDeviceInfo.getStatus());
            return tblDeviceInfo.getId();
        }

    }

    @Override
    public Integer selectName(TblDeviceInfo tblDeviceInfo) {
        return null;
    }


}
