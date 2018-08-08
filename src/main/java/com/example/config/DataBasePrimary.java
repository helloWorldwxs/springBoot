package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
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
        entityManagerFactoryRef="primaryEntityManagerFactory",
        transactionManagerRef="primaryEtransactionManager",
        basePackages= { "com.example.dao.primary" }) //设置Repository所在位置
@EnableTransactionManagement
public class DataBasePrimary {

    private final Environment env;

    public DataBasePrimary(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "primaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        DataSource dataSource = primaryDataSource();
        return builder
                .dataSource(primaryDataSource())
                //.properties(getVendorProperties(defaultDataSource()))
                .packages("com.example.bean.primary") //设置实体类所在位置
                .persistenceUnit("primary")
                .build();
    }

    @Bean(name = "primaryEtransactionManager")
    public JpaTransactionManager db2TransactionManager(@Qualifier("primaryEntityManagerFactory") final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
