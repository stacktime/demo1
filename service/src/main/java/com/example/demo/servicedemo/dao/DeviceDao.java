package com.example.demo.servicedemo.dao;

import com.example.demo.servicedemo.module.entity.DeviceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author WangYuanbo
 * @date 2022/4/3 21:03
 */
@Repository
public interface DeviceDao extends JpaRepository<DeviceDO, Integer> {

    DeviceDO findByIdAndDeleted(Integer id, Integer deleted);

    DeviceDO findByName(String name);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update tbl_device_info set status = ? where id = ? and deleted = ?")
    void updateStatusById(Integer status, Integer id, Integer deleted);

    void deleteById(Integer id);


}
