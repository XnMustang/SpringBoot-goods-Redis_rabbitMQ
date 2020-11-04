package com.wangjun.service;

public interface StockService {

    /**
     * 对指定商品的库存数量减 1
     * @param stockName
     */
    void decrByStock(String stockName);


    Integer selectByExample(String stockName);

}
