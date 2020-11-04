package com.wangjun.mapper;

import com.wangjun.base.GenericMapper;
import com.wangjun.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper extends GenericMapper<Order> {

    void insertOrder(Order order);
}