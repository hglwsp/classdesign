package com.example.classdesign.repository;

import com.example.classdesign.entity.User;
import com.example.classdesign.repository.SupRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.List;
;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SupRepositoryTest {
    @Autowired
    private SupRepository supRepository;
    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */

    @Test
    public void addUserTest() {
        User user = supRepository.addUser(new User("刘翰勋"));
        log.debug("{}", user.getInsertTime());
        user.setAuthority(User.Mann_AUTHORITY);
        user.setNumber("1002");
    }

    @Test
    public void remaveUserTest() {
        supRepository.remaveUser(5);
    }



    }

