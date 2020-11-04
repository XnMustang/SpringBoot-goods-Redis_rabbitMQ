package com.wangjun.service.impl;

import com.wangjun.mapper.OrderMapper;
import com.wangjun.pojo.Order;
import com.wangjun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        orderMapper.insert(order);
    }
}
