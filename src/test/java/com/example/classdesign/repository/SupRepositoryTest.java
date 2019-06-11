package com.example.classdesign.repository;

import com.example.classdesign.entity.User;
import com.example.classdesign.repository.SupRepository;
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
    public void addUserTest() {
        User user = new User("王胜朴");
        log.debug("{}", user.getInsertTime());
        user.setAuthority(User.Tea_AUTHORITY);
        user.setNumber("1003");
        user.setPnumber("18800463691");
        user.setIntro("hgl");
        user.setPro("教师");
        user.setPassword(passwordEncoder.encode(user.getNumber()));
        supRepository.addUser(user);
    }

    @Test
    public void remaveUserTest() {
        supRepository.remaveUser(5);
    }



    }
