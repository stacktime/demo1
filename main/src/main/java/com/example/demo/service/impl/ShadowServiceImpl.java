package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Shadow;
import com.example.demo.entity.dto.ShadowDTO;
import com.example.demo.service.ShadowService;
import com.example.demo.mapper.ShadowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 14266
* @description 针对表【shadow】的数据库操作Service实现
* @createDate 2022-05-12 22:54:40
*/
@Service
public class ShadowServiceImpl extends ServiceImpl<ShadowMapper,Shadow> implements ShadowService{

    @Autowired
    private ShadowMapper shadowMapper;

    @Override
    public Integer saveShadow(ShadowDTO shadowDTO) {
        Shadow shadow = dtoToDo(shadowDTO);
        return shadowMapper.insert(shadow);
    }

    @Override
    public ShadowDTO.MetadataBean.DesiredBeanX getById(Integer id) {

        Shadow shadow = shadowMapper.selectByPrimaryKey(id);
        ShadowDTO shadowDTO = doToDto(shadow);
        ShadowDTO.MetadataBean.DesiredBeanX desired = shadowDTO.getMetadata().getDesired();
        return desired;
    }

    private Shadow dtoToDo(ShadowDTO shadowDTO) {
        Shadow shadow = new Shadow();
        shadow.setMetadata(JSON.toJSONString(shadowDTO.getMetadata()));
        shadow.setState(JSON.toJSONString(shadowDTO.getState()));
        shadow.setVersion(shadowDTO.getVersion());
        shadow.setTimestamp(shadowDTO.getTimestamp());


        return shadow;

    }

    private ShadowDTO doToDto(Shadow shadow){
        ShadowDTO shadowDTO = new ShadowDTO();
        String state = shadow.getState();
        ShadowDTO.StateBean stateBean = JSON.parseObject(state, ShadowDTO.StateBean.class);
        String Metadata = shadow.getMetadata();
        ShadowDTO.MetadataBean metadataBean = JSON.parseObject(Metadata, ShadowDTO.MetadataBean.class);
        shadowDTO.setVersion(shadow.getVersion());
        shadowDTO.setState(stateBean);
        shadowDTO.setMetadata(metadataBean);
        shadowDTO.setTimestamp(shadow.getTimestamp());
        return shadowDTO;


    }

}
