package com.example.dao.second;

import com.example.bean.second.TypeOfArticle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 16:40
 * @Description:
 */
@Repository
@Transactional
public interface TypeOfArticleDao extends JpaRepository<TypeOfArticle,Integer> {
    List<TypeOfArticle> findAll(Sort.Direction desc, String createAt);

   /* @Modifying
    @Query(value = "UPDATE TypeOfArticle SET ar.typeName=:typeName where ar.id= :id")
    int update(@Param("typeName")String typeName,@Param("id")Integer id);*/
}
