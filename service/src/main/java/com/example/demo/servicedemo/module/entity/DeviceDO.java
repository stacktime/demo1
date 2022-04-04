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
@Table(name = "tbl_device_info")
public class DeviceDO {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 序列号
     */
    @Column(name = "code")
    private String code;

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
    /**
     * 删除标记 0 未删除
     */
    @Column(name = "deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 修改人
     */
    @Column(name = "modify_user")
    private String modifyUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeviceDO deviceDO = (DeviceDO) o;
        return id != null && Objects.equals(id, deviceDO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

