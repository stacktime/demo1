package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.Shadow;
import com.example.demo.entity.dto.ShadowDTO;

/**
* @author 14266
* @description 针对表【shadow】的数据库操作Service
* @createDate 2022-05-12 22:54:40
*/
public interface ShadowService extends IService<Shadow>{

    Integer saveShadow(ShadowDTO shdowDTO);

    ShadowDTO.MetadataBean.DesiredBeanX getById(Integer id);

}
