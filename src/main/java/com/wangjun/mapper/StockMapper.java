package com.wangjun.mapper;

import com.wangjun.base.GenericMapper;
import com.wangjun.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockMapper extends GenericMapper<Stock> {


}