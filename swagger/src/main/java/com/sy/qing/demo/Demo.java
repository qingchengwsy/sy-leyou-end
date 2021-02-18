package com.sy.qing.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: Su.Qing
 * @create: 2021-01-08 10:56
 **/
public class Demo {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("E:/1.txt");
            BufferedWriter bw=new BufferedWriter(fileWriter);
            for (int i=1; i<10000000;i++){
                String uuid= UUID.randomUUID().toString();
                bw.write(i+","+uuid+"\n");
            }
            bw.close();
            fileWriter.close();
            System.out.println("执行成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
