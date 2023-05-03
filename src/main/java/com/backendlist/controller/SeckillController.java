package com.backendlist.controller;

import com.backendlist.ListTools.R;
import com.backendlist.RedisSeckill.domain.Order;
import com.backendlist.RedisSeckill.mapper.GoodsMapper;
import com.backendlist.RedisSeckill.service.GoodsService;
import com.backendlist.RedisSeckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kj
 * @date 2023/5/2
 * @apiNote
 */
@RestController
@RequestMapping("/secill")
@Slf4j
public class SeckillController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderService orderService;
    @PostMapping("/seckillGoods")
    @Transactional(rollbackFor = Exception.class)
    public R<String> SeckillGoods(){
        Long stock= redisTemplate.opsForValue().decrement("ipone20");
        if (stock<0){
            stock=redisTemplate.opsForValue().increment("ipone20");
            log.info("========stock:{}",stock);
            System.out.println("****抢购失败****");
            return R.error(300,"商品已售完");
        }
        try {
            goodsMapper.updateRepertory();
            Order order=new Order();
            order.setName("ipone20");
            boolean save = orderService.save(order);
            int i=1/0;
            if (!save){
                log.info("保存订单失败!!!");
                throw new RuntimeException("保存订单失败!!!");
            }
        }catch (Exception e){
            redisTemplate.opsForValue().increment("ipone20");
            log.info("减少库存失败");
            goodsMapper.addRepertory();
            e.printStackTrace();
            // 手动硬编码开启spring事务管理
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error(500,"服务器繁忙");
        }

        return R.success(200,"恭喜您抢购成功");
    }
}
