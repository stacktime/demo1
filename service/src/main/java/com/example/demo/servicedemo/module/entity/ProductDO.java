package com.example.demo.servicedemo.module.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "iot_equipment_status")
public class ProductDO {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     * 设备名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 状态 (默认)0禁用 1启用 2失效 -1 断开链接
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "online")
    private Integer online;
    /**
     * 删除标记 0 未删除
     */
    @Column(name = "deleted")
    private Integer deleted;

}
