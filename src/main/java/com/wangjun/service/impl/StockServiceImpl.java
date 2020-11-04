package com.wangjun.service.impl;

import com.wangjun.mapper.StockMapper;
import com.wangjun.pojo.Stock;
import com.wangjun.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public void decrByStock(String stockName) {
        Example example = new Example(Stock.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", stockName);
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(stocks)) {
            Stock stock = stocks.get(0);
            stock.setStock(stock.getStock() - 1);
            stockMapper.updateByPrimaryKey(stock);
        }
    }

    @Override
    public Integer selectByExample(String stockName) {
        Example example = new Example(Stock.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", stockName);
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(stocks)) {
            return stocks.get(0).getStock().intValue();
        }
        return 0;
    }
}
