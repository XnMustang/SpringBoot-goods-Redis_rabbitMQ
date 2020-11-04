
## 数据库：
    bookstore
## 数据表：
    >商品库存表：stock
                id,name,stock

    >秒杀订单表：t_order
                id,order_name,order_user

## 前提条件：
    RabbitMQ
    Redis + RedisDesktopManager
    Jmeter压力测试工具
        Jmeter为基于java的压力测试工具,在此项目demo中用它模仿40个不同得用户同时发送请求秒杀商品

## 创建springboot项目
    导入pom依赖
    配置application.properties

##### 这个时候准备工作已经完成，启动项目看看有没有报错，测试以下配置的是否有问题


### 填充项目：
    1.创建包结构
        com.wangjun
            base:
                GenericMapper   使用tkmybatis框架，需要一个mapper继承他来实现数据库操作，相当于mybatis plus
                
            config:
                MyRabbitMQConfig    MQ配置
                RedisConfig         Redis配置
                
            controller:
                SecController       控制器
            
            mapper:
                OrderMapper
                StockMapper
            
            pojo:
                因为本次数据库操作方面使用了tkmybatis框架，所以实体类我们需要用到JPA的注解，来实现映射关系！
                Order
                Stock
            
            service:
                MQOrderService  监听订单消息队列，并消费
                MQStockService  监听库存消息队列，并消费
                OrderService    
                RedisService
                StockService
                
                impl:
                    OrderServiceImpl
                    StockServiceImpl
        启动类：
            GodsRedisMQApplication.java                        
         
    

##结论：
    redis对于下订单接口没有提高吞吐量和响应速度的帮助，
    使用redis的作用是这些操作的数据都缓存在了redis，
    当再次用到的时候就不需要读取数据库，对于高并发读取数据库是很有帮助的，
    但需要考虑下缓存和数据库的数据一致性的问题    

此项目来源：https://www.geek-share.com/detail/2789831359.html
