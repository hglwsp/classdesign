package com.example.classdesign.repository;

import com.example.classdesign.entity.Monitor;
import com.example.classdesign.entity.Work;
import com.example.classdesign.repository.MannRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;

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
    public void addWork() {                 /*管理员增加任务*/
        Work work = new Work("系统程序设计");
        log.debug("{}", work.getInsertTime());
        work.setDetail("100");
        work.setResp(1);
        work.setWarn(1);
        work.setRespdetail("刘翰勋");
        work.setEndtime(LocalDateTime.of(2019, 6, 14, 17, 25));
        mannRepository.addWork(work);
    }

    @Test
    public void updateWork() {                /*管理员修改任务*/
        Work work = mannRepository.updateWork(2, "王胜朴");
        log.debug("{}", work.getDetail());
    }

    @Test
    public void remaveWork() {              /*管理员删除任务*/
        mannRepository.remaveWork(2);
    }

    @Test
    public void addMonitor() {         /*管理员添加监考信息*/
        Monitor monitor = new Monitor("1008");
        monitor.setName("系统程序设计");
        log.debug("{}", monitor.getInsertTime());
        monitor.setUsername1("王胜朴");
        monitor.setUsername2("贺国兰");
        monitor.setStarttime(LocalDateTime.of(2019, 6, 18, 15, 25));
        monitor.setEndtime(LocalDateTime.of(2019, 6, 18, 17, 25));
        monitor.setPlace("748");
        monitor.setMan(2);
        mannRepository.addMonitor(monitor);
    }

    @Test
    public void updateMonitor1() {        /*管理员修改监考人员*/
        Monitor monitor = mannRepository.updateMonitor1(4, "张锐");
        log.debug("{}", monitor.getUsername1());
    }

    @Test
    public void updateMonitor2() {
        Monitor monitor = mannRepository.updateMonitor2(4, "郭鹏鑫");
        log.debug("{}", monitor.getUsername2());
    }
}