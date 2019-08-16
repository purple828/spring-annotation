package com.flj.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author flj
 * @Description:  @Component ：默认加载ioc容器中的组件，容器启动会调用无参构造器，然后创建对象，再进行初始化赋值等操作
 * @date 2019-08-16 10:39
 **/
@Component
@ToString
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    /**
     * 构造器要用的组件，都是从容器中获取
     * @param car
     */
    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器...");
    }

    public Boss() {
    }

    /**
     * 标注在方法，spring容器创建当前对象就会调用方法，完成赋值，方法使用的参数，自定义类型的值从ioc容器中获取
     * @param car
     */
//    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
}
