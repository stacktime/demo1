package com.example.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.Const;
import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.entity.DeviceDO2;
import com.example.demo.mapper.TblDeviceInfoMapper;
import com.example.demo.service.TblDeviceInfoService;
import com.example.demo.servicedemo.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 14266
 * @description 针对表【tbl_device_info】的数据库操作Service实现
 * @createDate 2022-05-04 00:20:01
 */
@Service
public class TblDeviceInfoServiceImpl extends ServiceImpl<TblDeviceInfoMapper, TblDeviceInfo> implements TblDeviceInfoService {
    @Autowired
    private TblDeviceInfoMapper tblDeviceInfoMapper;


    /**
     * 返回值是否正确
     * devicedId每个方法都要用到可不可以写在外边
     * 除了添加操作其他操作是否需要验证表中是否存在数据
     *
     * @param tblDeviceInfo
     * @return
     */
    @Override
    public Integer insertStatus(TblDeviceInfo tblDeviceInfo) {
        DeviceDO2 deviceDO2;
        Integer deviceId = tblDeviceInfo.getId();
        deviceDO2 = tblDeviceInfoMapper.findById(deviceId);
        if (deviceDO2 == null) {
            deviceDO2 = new DeviceDO2();
            deviceDO2.setId(tblDeviceInfo.getId());
            deviceDO2.setCode(tblDeviceInfo.getCode());
            deviceDO2.setName(tblDeviceInfo.getName());
            deviceDO2.setStatus(tblDeviceInfo.getStatus());
            deviceDO2.setDeleted(tblDeviceInfo.getDeleted());
            deviceDO2.setGmtCreate(Constant.Time);
            deviceDO2.setCreateUser(tblDeviceInfo.getCreateUser());
            deviceDO2.setGmtModify(Constant.Time);
            deviceDO2.setModifyUser(tblDeviceInfo.getModifyUser());
            tblDeviceInfoMapper.insertUser(deviceDO2);

            return tblDeviceInfo.getId();
        } else {
            throw new RuntimeException(deviceId + "已存在");
        }

    }

    @Override
    public String deleted(TblDeviceInfo tblDeviceInfo) {
        DeviceDO2 deviceDO2;
        Integer deviceId = tblDeviceInfo.getId();
        deviceDO2 = tblDeviceInfoMapper.findById(deviceId);//这句是否必要？
        if (deviceDO2 == null || Const.DELETED.equals(tblDeviceInfo.getDeleted())) {

            return ("该设备不存在或已被删除");
        } else {
            tblDeviceInfoMapper.deleteById(deviceId);
            /**
             * 会不会因为网络原因删除失败但是返回值成功
             */
            return ("删除成功");
        }

    }

    @Override
    public Integer updateData(TblDeviceInfo tblDeviceInfo) {
        if (Const.DELETED.equals(tblDeviceInfo.getDeleted()) || tblDeviceInfo.getId() == null) {
            /**
             * 该设备不存在
             */
            return tblDeviceInfo.getId();
        } else {
            tblDeviceInfoMapper.updateById(tblDeviceInfo.getId(), tblDeviceInfo.getStatus());
            return tblDeviceInfo.getId();
        }

    }


    @Override
    public Integer selectName(TblDeviceInfo tblDeviceInfo) {
        return null;
    }

    @Override
    public boolean save(TblDeviceInfo entity) {
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<TblDeviceInfo> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TblDeviceInfo> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean removeById(TblDeviceInfo entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return super.removeByIds(list, useFill);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return super.removeBatchByIds(list);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list, boolean useFill) {
        return super.removeBatchByIds(list, useFill);
    }

    @Override
    public boolean updateById(TblDeviceInfo entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<TblDeviceInfo> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    public boolean update(TblDeviceInfo entity, Wrapper<TblDeviceInfo> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean updateBatchById(Collection<TblDeviceInfo> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public TblDeviceInfo getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<TblDeviceInfo> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public List<TblDeviceInfo> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    public TblDeviceInfo getOne(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long count(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public List<TblDeviceInfo> list(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public List<TblDeviceInfo> list() {
        return super.list();
    }

    @Override
    public <E extends IPage<TblDeviceInfo>> E page(E page, Wrapper<TblDeviceInfo> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public <E extends IPage<TblDeviceInfo>> E page(E page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Object> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<TblDeviceInfo> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<TblDeviceInfo> queryWrapper, Function<? super Object, V> mapper) {
        return super.listObjs(queryWrapper, mapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<TblDeviceInfo> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<TblDeviceInfo> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<TblDeviceInfo> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public KtQueryChainWrapper<TblDeviceInfo> ktQuery() {
        return super.ktQuery();
    }

    @Override
    public KtUpdateChainWrapper<TblDeviceInfo> ktUpdate() {
        return super.ktUpdate();
    }

    @Override
    public UpdateChainWrapper<TblDeviceInfo> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<TblDeviceInfo> lambdaUpdate() {
        return super.lambdaUpdate();
    }

    @Override
    public boolean saveOrUpdate(TblDeviceInfo entity, Wrapper<TblDeviceInfo> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }
}
