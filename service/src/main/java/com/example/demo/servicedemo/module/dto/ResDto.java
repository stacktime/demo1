package com.example.demo.servicedemo.module.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ResDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 序列号
     */
    private String code;
    /**
     * 设备名
     */
    private String name;
    /**
     * 设备状态
     */
    private Integer status;
    /**
     * 启用禁用
     */
    private Integer online;
    /**
     * 是否删除
     */
    private Integer deleted;
    /**
     * 创建时间
     */
    //private Date gmtCreate;
    /**
     * 创建人
     */
    private String createUser;
    /**
     *修改时间
     */
    //private Date gmtModify;
    /**
     *修改人
     */
    private String modifyUser;

}
