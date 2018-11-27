package com.example.dao.second;

import com.example.bean.second.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/4 10:08
 * @Description:
 */
@Repository
@Transactional
public interface ArticleDao extends JpaRepository<Article,Integer> {
    List<Article> findByAvailableTrueOrderByCreatedAt();
    Article findByIdEqualsAndAvailableTrue(Integer id);
}
