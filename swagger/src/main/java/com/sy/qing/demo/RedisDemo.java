package com.sy.qing.demo;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: Su.Qing
 * @create: 2021-01-11 14:50
 **/
@Component
public class RedisDemo {

    public static ThreadPoolExecutor pool=new ThreadPoolExecutor(
            10,100,10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.select(0);
        jedis.set("num","50");
        jedis.del("user");
        jedis.close();
        for (int i=0;i<1000;i++){
            pool.execute(new KillTask());
        }
    }
}
