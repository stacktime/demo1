package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName tbl_device_info
 */
public class TblDeviceInfo implements Serializable {
    /**
     *
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

    /**
     * 删除标记 0 未删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date gmtModify;

    /**
     *
     */
    private String modifyUser;

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 序列号
     */
    public String getCode() {
        return code;
    }

    /**
     * 序列号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 状态 (默认)0禁用 1启用 2失效 -1 断开链接
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 (默认)0禁用 1启用 2失效 -1 断开链接
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 删除标记 0 未删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 删除标记 0 未删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 更新时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 更新时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     *
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TblDeviceInfo other = (TblDeviceInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
                && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
                && (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createUser=").append(createUser);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}