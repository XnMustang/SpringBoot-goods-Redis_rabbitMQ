package com.wangjun.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "stock")
@Data
public class Stock implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //提供主键生成策略
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Long stock;
}