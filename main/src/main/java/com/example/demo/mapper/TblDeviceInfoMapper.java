package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.entity.DeviceDO2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14266
 * @description 针对表【tbl_device_info】的数据库操作Mapper
 * @createDate 2022-05-04 00:20:01
 * @Entity com.example.demo.domain.TblDeviceInfo
 */
@Service
public interface TblDeviceInfoMapper extends BaseMapper<TblDeviceInfo> {

    Integer insertUser(DeviceDO2 deviceDO2);

    @Override
    int insert(TblDeviceInfo entity);

    Integer deleteById(Integer id);

    Integer updateById(Integer id, Integer status);

    DeviceDO2 findById(Integer id);


    List<TblDeviceInfo> selectAllUser();
}
