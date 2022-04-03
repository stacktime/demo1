package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author WangYuanbo
 * @date 2022/4/3 21:06
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.servicedemo.dao",
        entityManagerFactoryRef = "testDemoEntityManagerFactory",
        transactionManagerRef = "testDemoTransactionManager")
public class DataSourceConfig {

    @Autowired
    JpaProperties jpaProperties;
    @Autowired
    private DataSource testDemoDataSource;

    @Bean
    public PlatformTransactionManager testDemoTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(testDemoEntityManagerFactory(builder).getObject());
    }

    @Primary
    public LocalContainerEntityManagerFactoryBean testDemoEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(testDemoDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.example.demo.servicedemo.module.entity") // 设置实体类所在位置
                .persistenceUnit("testDemoPersistenceUnit")
                .build();

    }

    @Bean
    public JdbcTemplate testDemoJdbcTemplate() {
        return new JdbcTemplate(testDemoDataSource);
    }


    @Bean
    public DataSource testDemoDataSource() {
        return new DelegatingDataSource();
    }

}
