package com.example.demo.servicedemo.dao;

import com.example.demo.servicedemo.module.entity.DeviceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author WangYuanbo
 * @date 2022/4/3 21:03
 */
@Repository
public interface DeviceDao extends JpaRepository<DeviceDO, Integer> {
}