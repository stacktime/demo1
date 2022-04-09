package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.dao.DeviceDao;
import com.example.demo.servicedemo.dao.ProductDao;
import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.module.entity.DeviceDO;
import com.example.demo.servicedemo.module.entity.ProductDO;
import com.example.demo.servicedemo.service.DeviceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service

public class DeviceManagementImpl implements DeviceManagement {

    @Autowired
    private ProductDao productDao;

    /**
     * 创建设备
     * @param resDto
     * @return
     */
    @Override
    public Integer createDevice(ResDto resDto) {
        ProductDO productDO ;
        String deviceName = resDto.getName();
        productDO = productDao.findByName(deviceName);
        if (productDO == null) {
            productDO = new ProductDO();
            productDO.setId(resDto.getId());
            productDO.setName(resDto.getName());
            productDO.setStatus(resDto.getStatus());
            productDO.setOnline(resDto.getOnline());
            productDO.setDeleted(resDto.getDeleted());
            productDao.saveAndFlush(productDO);
        }else {
            throw new RuntimeException(deviceName + "已存在");
        }

        return 1;
    }

    /**
     * 创建产品
     * @param resDto
     * @return
     */
    @Override
    public Integer createProduct(ResDto resDto) {
        ProductDO productDO;
        String productName = resDto.getName();
        productDO = productDao.findByName(productName);
        if(productDO == null){
            productDO.setId(resDto.getId());
            productDO.setName(resDto.getName());
            productDO.setStatus(resDto.getStatus());
            productDao.saveAndFlush(productDO);
        }else {
            throw new RuntimeException(productName+"已存在");
        }

        return null;
    }

    /**
     * 上下线
     */
    @Override
    public Integer upAndDown(ResDto resDto) {
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if(pDo == null){
            throw new RuntimeException(pDo+"该设备已经被删除");
        }else {
            Integer productOnline = resDto.getOnline();
            Integer productDeleted = resDto.getDeleted();
            productDao.updateStatusById(productOnline , productName , productDeleted);
        }
        return null;
    }

    /**
     * 启用和禁用
     */
    @Override
    public Integer enableAndDisable(ResDto resDto) {
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if(pDo == null) {
            throw new RuntimeException(productName+"设备不存在");
        }else {
            Integer productStatus = resDto.getStatus();
            productDao.enableAndDisable(productStatus , productName);
        }
        return null;
    }

    /**
     * 删除设备
     */
    @Override
    public Integer deletedProduct(ResDto resDto) {
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if(pDo == null) {
            throw new RuntimeException(productName+"已经不存在");
        }else {
            Integer productDeleted = resDto.getDeleted();
            productDao.deletedProduct(productDeleted , productName);
        }
        return null;
    }
}
