package com.example.service;

import com.example.bean.second.Product;
import com.example.dao.second.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

/**
 * Copyright (C), 2015-2018
 * FileName: ProductService
 * Author:   wuxiaosen
 * Date:     2018/7/12 0012 17:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product findById(Integer id){
        Optional<Product> optional = productDao.findById(id);
        return optional.get();
    }
    public Integer findByStock(Integer id){
        Optional<Product> optional = productDao.findById(id);
        return optional.get().getStock();
    }
}
