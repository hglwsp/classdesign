package com.example.classdesign.repository;



import com.example.classdesign.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Work, Integer> {
    /**
     * 获取指定ID的用户
     * @param
     * @return
     */
    @Query("SELECT u FROM Work u  ")
    List<Work> list();
}