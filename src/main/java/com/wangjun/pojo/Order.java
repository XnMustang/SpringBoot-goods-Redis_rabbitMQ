package com.wangjun.pojo;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "t_order")
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //提供主键生成策略
    private Long id;

    @Column(name = "order_name")
    private String order_name;

    @Column(name = "order_user")
    private String order_user;
}