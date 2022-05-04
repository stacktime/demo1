package com.example.demo;


import com.example.demo.domain.TblDeviceInfo;
import com.example.demo.mapper.TblDeviceInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import javax.persistence.Id;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void getAll() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        TblDeviceInfoMapper mapper = sqlSession.getMapper(TblDeviceInfoMapper.class);

        //TblDeviceInfo user = mapper.selectById(4);
       // System.out.println(user);
    }

    @Test
    public void selectById() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        TblDeviceInfoMapper mapper = sqlSession.getMapper(TblDeviceInfoMapper.class);

        List<TblDeviceInfo> list = mapper.selectAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void updateByname() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        TblDeviceInfoMapper mapper = sqlSession.getMapper(TblDeviceInfoMapper.class);

        //mapper.deleteById();
    }

    @Test
    public void updateById() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TblDeviceInfoMapper mapper = sqlSession.getMapper(TblDeviceInfoMapper.class);
        //mapper.updateById();

    }

    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取mapper接口对象
        TblDeviceInfoMapper mapper = sqlSession.getMapper(TblDeviceInfoMapper.class);//代理模式


        //测试功能
        //int result = mapper.insertUser();
        //提交事务
        //sqlSession.commit();
        //System.out.println("result:"+result);

    }
}
