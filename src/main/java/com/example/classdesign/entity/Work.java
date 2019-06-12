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
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String detail;
    @ManyToOne(fetch = FetchType.LAZY)
    private User mann;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    private int resp;         /*1回复2未回复*/
    private int warn;         /*1按时完成不警告 2警告记录未按时完成*/
    private String respdetail;

    public Work(int id) {
        this.id = id;
    }
    public Work(String name) {
        this.name = name;
    }


}