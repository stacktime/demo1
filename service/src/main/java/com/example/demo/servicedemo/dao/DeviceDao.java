package com.example.demo.servicedemo.dao;

import com.example.demo.servicedemo.module.entity.DeviceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author WangYuanbo
 * @date 2022/4/3 21:03
 */
@Repository
public interface DeviceDao extends JpaRepository<DeviceDO, Integer> {

    DeviceDO findByIdAndDeleted(Integer id, Byte deleted);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update tbl_device_info set status = ?2 where id = ?1 and deleted = 0")
    void updateStatusById(Integer id, Integer status);



}
