package com.wangjun;

import com.wangjun.service.RedisService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangjun.mapper")
public class Springboot17GoodsRedisMqApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Springboot17GoodsRedisMqApplication.class, args);
    }

    @Autowired
    private RedisService redisService;

    /**
     * redis初始化商品的库存量和信息
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisService.put("watch", 10, 20);
    }
}
