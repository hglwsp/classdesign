package com.example.classdesign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;                /*回复人姓名*/
    private String detail;             /*回复内容*/
    private LocalDateTime finishtime;    /*回复完成时间*/
    private int ontime;               /*1按时2不按时*/
    @ManyToOne(fetch = FetchType.LAZY)
    private Work work;
    @ManyToOne(fetch = FetchType.LAZY)
    private User teacher;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;

    public WorkDetail(int id) {
        this.id = id;
    }
    public WorkDetail(String name) {
        this.name = name;
    }
}