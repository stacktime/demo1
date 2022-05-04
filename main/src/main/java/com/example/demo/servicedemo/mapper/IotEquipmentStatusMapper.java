package com.example.demo.servicedemo.mapper;

import com.example.demo.servicedemo.module.entity.IotEquipmentStatusDO;
import org.springframework.stereotype.Repository;

/**
 * @author WangYuanbo
 * @date 2022/5/4 12:52
 */
@Repository
public interface IotEquipmentStatusMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(IotEquipmentStatusDO record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(IotEquipmentStatusDO record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    IotEquipmentStatusDO selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(IotEquipmentStatusDO record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(IotEquipmentStatusDO record);
}