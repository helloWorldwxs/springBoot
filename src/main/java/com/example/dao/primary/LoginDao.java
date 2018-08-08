package com.example.dao.primary;

import com.example.bean.primary.Login;
import com.example.util.PropertyValueConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C), 2015-2018
 * FileName: LoginDao
 * Author:   wuxiaosen
 * Date:     2018/7/6 0006 11:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Repository
@Transactional
public interface LoginDao extends JpaRepository<Login,Integer> {

    List<Login> findByAvailableIsAndNameIs(Boolean avrilable, String name);

}
