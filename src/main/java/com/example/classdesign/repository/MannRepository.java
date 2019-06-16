package com.example.classdesign.repository;

import com.example.classdesign.entity.Monitor;
import com.example.classdesign.entity.Work;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MannRepository {
    @PersistenceContext
    private  EntityManager em;

    /**
     * 管理员添加任务，并返回包括数据库时间戳的用户对象
     */
    public  Work addWork(Work work) {
        em.persist(work);
        em.refresh(work);
        return work;
    }

    /**
     * 更新指定ID的任务
     */
    public Work updateWork(int uid, String newDetail) {
        Work work = new Work();
        work.setId(uid);
        Work newWork = em.merge(work);
        em.refresh(newWork);
        newWork.setDetail(newDetail);
        return newWork;
    }


    /**
     * 删除任务，设置级联操作或手动删除相关地址
     */
    public void remaveWork(int uid) {
        Work work = em.find(Work.class, uid);
        em.remove(work);
        return ;
    }


    /**
     * 管理员添加监考，并返回包括数据库时间戳的用户对象
     */
    public Monitor addMonitor(Monitor monitor) {
        em.persist(monitor);
        em.refresh(monitor);
        return monitor;
    }


    /**
     * 更新指定id的username1监考员1
     */
    public Monitor updateMonitor1(int uid, String newUsername1) {
        Monitor monitor = new Monitor();
        monitor.setId(uid);
        Monitor newMonitor = em.merge(monitor);
        em.refresh(newMonitor);
        newMonitor.setUsername1(newUsername1);
        return newMonitor;
    }


    /**
     * 更新指定ID的username2监考员2
     */
    public Monitor updateMonitor2(int uid, String newUsername2) {
        Monitor monitor = new Monitor();
        monitor.setId(uid);
        Monitor newMonitor = em.merge(monitor);
        em.refresh(newMonitor);
        newMonitor.setUsername2(newUsername2);
        return newMonitor;
    }
}