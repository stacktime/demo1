package com.example.demo.servicedemo.module.dto;

import lombok.Data;

/**
 * @author WangYuanbo
 * @date 2022/4/3 16:27
 */
@Data
public class RequestDTO {
    /**
     * id,修改的时候使用
     */
    private Integer id;
    /**
     * 序列号
     */
    private String code;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 状态 (默认)0禁用 1启用 2失效 -1 断开链接
     */
    private Integer status;
}
