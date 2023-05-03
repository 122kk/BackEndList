package com.backendlist.RedisSeckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backendlist.RedisSeckill.domain.Order;
import com.backendlist.RedisSeckill.service.OrderService;
import com.backendlist.RedisSeckill.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author kj
* @description 针对表【order】的数据库操作Service实现
* @createDate 2023-05-03 00:07:02
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




