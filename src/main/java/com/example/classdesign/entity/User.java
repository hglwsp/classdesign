package com.example.classdesign.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int Tea_AUTHORITY = 0;            /*权限*/
    public static final int Mann_AUTHORITY = 1;
    public static final int SuperMann_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;           /*编号*/
    private String name;
    private String pro;              /*职称*/
    private String intro;            /*介绍*/
    private String pnumber;          /*手机*/
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 在没有声明时默认为1
    private int authority = 0;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;

    public User(int id) {
        this.id = id;
    }
    public User(String name) {
        this.name = name;
    }


}