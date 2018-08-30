package com.example.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.bean.primary.RUser;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/8/20 16:26
 * @Description:
 */
@Repository
@Transactional
public interface RUserDao extends JpaRepository<RUser, Long> {
    List<RUser> findByAvailableTrueAndIdCardNoNotNullAndAgeNull();
    @Modifying
    @Query(value="UPDATE RUser xe SET xe.age= :age WHERE xe.id= :id")
    int  update(@Param("age")Integer age,@Param("id")Long id);
}
