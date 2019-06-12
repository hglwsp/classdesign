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
public class MannRepositoryTest {


    @Autowired
    private MannRepository mannRepository;

    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     */
    @Test
    public void addWork() {
        Work work = new Work("兰兰最美");
        log.debug("{}", work.getInsertTime());
        work.setDetail("1314");
        work.setResp(1);
        work.setWarn(1);
        work.setRespdetail("兰兰");
        mannRepository.addWork(work);
    }

    @Test
    public void updateWork() {
        Work work = mannRepository.updateWork(2, "王胜朴");
        log.debug("{}", work.getDetail());
    }

    @Test
    public void remaveWork() {
        mannRepository.remaveWork(1);
    }
}