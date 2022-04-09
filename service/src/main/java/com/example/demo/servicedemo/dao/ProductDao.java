package com.example.demo.servicedemo.dao;

import com.example.demo.servicedemo.module.entity.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Repository
public interface ProductDao extends JpaRepository<ProductDO , Integer>  {
    ProductDO findByName(String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "update  iot_equipment_status set online = ?1 where name = ?2 and deleted = ?3")
    void updateStatusById(Integer online , String name , Integer deleted);

    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "update  iot_equipment_status set deleted = ?1 where name = ?2")
    void deletedProduct(Integer deleted , String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "update  iot_equipment_status set status = ?1 where name = ?2")
    void enableAndDisable(Integer status , String name);

}

