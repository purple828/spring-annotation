package com.flj.bean;

import org.springframework.stereotype.Component;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 15:21
 **/
@Component
public class Car {
    public Car() {
        System.out.println("car constructor ...");
    }

    public void init(){
        System.out.println("car init...");
    }

    public void destory(){
        System.out.println("car destory...");

    }
}
