package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.entity.DeviceDO2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14266
 * @description 针对表【tbl_device_info】的数据库操作Mapper
 * @createDate 2022-05-04 00:20:01
 * @Entity com.example.demo.domain.TblDeviceInfo
 */
@Repository
public interface TblDeviceInfoMapper extends BaseMapper<DeviceDO2> {

    Integer insertUser(DeviceDO2 deviceDO2);

    @Override//重写
    int insert(DeviceDO2 entity);

    Integer deleteById(Integer id);

    Integer updateById(Integer id, Integer status);

    DeviceDO2 findById(Integer id);


    List<TblDeviceInfo> selectAllUser();
}
