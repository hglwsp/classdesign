package com.example.classdesign.repository;

import com.example.classdesign.entity.User;
import com.example.classdesign.repository.SupRepository;
import com.example.classdesign.service.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SupRepositoryTest {
    @Autowired
    private SupRepository supRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */

    @Test
    public void addUserTest() {           /*超级管理员添加用户*/
        User user = new User("王一");
        log.debug("{}", user.getInsertTime());
        user.setAuthority(User.Tea_AUTHORITY);
        user.setNumber("1007");
        user.setPnumber("123456");
        user.setIntro("王一在吃饭");
        user.setPro("教师");
        user.setPassword(passwordEncoder.encode(user.getNumber()));
        user.setState(2);
        supRepository.addUser(user);

        User user2 = new User("王二");
        log.debug("{}", user2.getInsertTime());
        user2.setAuthority(User.Mann_AUTHORITY);
        user2.setNumber("1008");
        user2.setPnumber("18800463691");
        user2.setIntro("王二在睡觉");
        user2.setPro("教授");
        user2.setPassword(passwordEncoder.encode(user2.getNumber()));
        user.setState(1);
        supRepository.addUser(user2);
    }



    @Test
    public void updateUserTest() {           /*超级管理员更改信息，权限*/
        User user = supRepository.updateUser(8, 1, "方立军");
        log.debug("{}", user.getName());
    }


    @Test
    public void remaveUserTest() {             /*超级管理员删除用户*/
        supRepository.remaveUser(6);
    }



    }


