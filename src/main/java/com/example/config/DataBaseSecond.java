package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * Copyright (C), 2015-2018
 * FileName: DataBasePrimary
 * Author:   wuxiaosen
 * Date:     2018/7/6 0006 11:18
 * Description: 默认的链接数据库配置文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef="secondEntityManagerFactory",
        transactionManagerRef="secondEtransactionManager",
        basePackages= { "com.example.dao.second" }) //设置Repository所在位置
@EnableTransactionManagement
public class DataBaseSecond {

    private final Environment env;

    public DataBaseSecond(Environment env) {
        this.env = env;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        DataSource dataSource = secondDataSource();
        return builder
                .dataSource(secondDataSource())
                //.properties(getVendorProperties(defaultDataSource()))
                .packages("com.example.bean.second") //设置实体类所在位置
                .persistenceUnit("second")
                .build();
    }

    @Bean(name = "secondEtransactionManager")
    public JpaTransactionManager db2TransactionManager(@Qualifier("secondEntityManagerFactory") final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
