package com.sy.qing.demo;

import org.apache.commons.lang3.RandomStringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: Su.Qing
 * @create: 2021-01-11 15:10
 **/
public class KillTask implements Runnable {

    @Override
    public void run() {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.select(0);
        int num= Integer.parseInt(jedis.get("num"));
        jedis.watch("num","user");
        Transaction transaction=jedis.multi();
        if (num>0){
            transaction.decr("num");
            transaction.rpush("user", RandomStringUtils.randomNumeric(8));
            transaction.exec();
        }else {
            RedisDemo.pool.shutdown();
        }
        jedis.close();
    }
}
