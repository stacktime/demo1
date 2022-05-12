package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.Shadow;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 14266
* @description 针对表【shadow】的数据库操作Mapper
* @createDate 2022-05-12 22:54:40
* @Entity com.example.demo.domain.Shadow
*/
@Mapper
public interface ShadowMapper extends BaseMapper<Shadow> {

    int insert(Shadow shadow);

    Shadow selectByPrimaryKey(Integer id);

}
