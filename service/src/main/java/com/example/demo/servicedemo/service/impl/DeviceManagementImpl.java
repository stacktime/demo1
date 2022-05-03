package com.example.demo.servicedemo.service.impl;

import com.example.demo.servicedemo.dao.ProductDao;
import com.example.demo.servicedemo.module.dto.ResDto;
import com.example.demo.servicedemo.module.entity.ProductDO;
import com.example.demo.servicedemo.service.DeviceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DeviceManagementImpl implements DeviceManagement {

    @Autowired
    private ProductDao productDao;

    /**
     * 创建设备
     *
     * @param resDto
     * @return
     */
    @Override
    public Integer createDevice(ResDto resDto) {
        ProductDO productDO;
        /*
         * TODO
         *  Integer resDtoId = resDto.getId();
         *  一般用id(主键)去查,保证唯一性
         *  name可能重名,那你的这个查询就会报错
         */
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
        } else {
            /*
             * 用id就不会存在这个判断
             */
            throw new RuntimeException(deviceName + "已存在");
        }

        /*
         * 一般返回id给前端,不能直接返回个数字.没有任何意义,
         * 如果错误没报错,或者程序自己吞了报错用户不知道他有没有创建成功
         */
        return resDto.getId();
    }

    /**
     * 创建产品
     * TODO 同上
     *
     * @param resDto
     * @return
     */
    @Override
    public Integer createProduct(ResDto resDto) {
        ProductDO productDO;
        String productName = resDto.getName();
        productDO = productDao.findByName(productName);
        if (productDO == null) {
            // 没有new
            productDO = new ProductDO();
            productDO.setId(resDto.getId());
            productDO.setName(resDto.getName());
            productDO.setStatus(resDto.getStatus());
            productDao.saveAndFlush(productDO);
        } else {
            throw new RuntimeException(productName + "已存在");
        }
        // 返回同上
        return resDto.getId();
    }

    /**
     * 上下线
     */
    @Override
    public Integer upAndDown(ResDto resDto) {
        // id同上
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if (pDo == null) {
            // TODO 变量已经是null  你还放进去打印,肯定报空指针
            throw new RuntimeException(productName + "该设备已经被删除");
        } else {
            Integer productOnline = resDto.getOnline();
            /*
             * 一般删除标记不让前端传,由后端和功能去控制(如果前端传了个4 你咋知道是什么意思)
             * 简单来说 只有删除会设置这个值,其他默认都是非删除的(删除的他也看不见,怎么操作)
             *
             */
            Integer productDeleted = resDto.getDeleted();
            productDao.updateStatusById(productOnline, productName, productDeleted);
        }
        // 返回同上
        return resDto.getId();
    }

    /**
     * 启用和禁用
     */
    @Override
    public Integer enableAndDisable(ResDto resDto) {
        // id同上
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if (pDo == null) {
            throw new RuntimeException(productName + "设备不存在");
        } else {
            Integer productStatus = resDto.getStatus();
            productDao.enableAndDisable(productStatus, productName);
        }
        // 返回同上
        return resDto.getId();
    }

    /**
     * 删除设备
     */
    @Override
    public Integer deletedProduct(ResDto resDto) {
        // id同上
        String productName = resDto.getName();
        ProductDO pDo = productDao.findByName(productName);
        if (pDo == null) {
            throw new RuntimeException(productName + "已经不存在");
        } else {
            Integer productDeleted = resDto.getDeleted();
            productDao.deletedProduct(productDeleted, productName);
        }
        // 返回同上
        return resDto.getId();
    }
}
