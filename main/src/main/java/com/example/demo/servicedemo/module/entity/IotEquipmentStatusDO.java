package com.example.demo.servicedemo.module.entity;

import lombok.Data;

/**
 * @author WangYuanbo
 * @date 2022/5/4 12:52
 */
@Data
public class IotEquipmentStatusDO {
    private Integer id;

    private String name;

    private Integer status;

    private Integer online;

    private Integer deleted;
}