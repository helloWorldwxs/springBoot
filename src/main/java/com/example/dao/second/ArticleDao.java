package com.example.dao.second;

import com.example.bean.second.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/4 10:08
 * @Description:
 */
public interface ArticleDao extends JpaRepository<Article,Integer> {
    List<Article> findByAvailableTrueAndOrderByCreatedAt();
}
