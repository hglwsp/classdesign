package com.example.classdesign.repository;

import com.example.classdesign.entity.Work;
import com.example.classdesign.repository.MannRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void userRepTest() {
        teacherRepository.list()
        .forEach(u -> {
            log.debug("{}", u.getName());
            log.debug("{}", u.getRespdetail());
        });
    }
}