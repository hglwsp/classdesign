package com.example.classdesign.repository;

import com.example.classdesign.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupRepository {
    @PersistenceContext
    private  EntityManager em;

    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     */
    public  User addUser(User user) {
        em.persist(user);
        em.refresh(user);
        return user;
    }

    /**
     * 更新指定ID用户的姓名
     */
    public User updateUser(int uid, String newName) {
        User user = new User();
        user.setId(uid);
        User newUser = em.merge(user);
        em.refresh(newUser);
        newUser.setName(newName);
        return newUser;
    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     */
    public void remaveUser(int uid) {
        User user = em.find(User.class, uid);
        em.remove(user);
        return ;
    }

}