package com.example.dao.second;

import com.example.bean.second.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (C), 2015-2018
 * FileName: GirlDao
 * Author:   wuxiaosen
 * Date:     2018/7/6 0006 15:07
 * Description: DAO层数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Repository
@Transactional
public interface GirlDao extends JpaRepository<Girl,Integer>{

}
