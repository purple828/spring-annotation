package com.flj.test;

import com.flj.bean.Boss;
import com.flj.bean.Car;
import com.flj.bean.Color;
import com.flj.bean.Person;
import com.flj.config.MainConfigOfAutowired;
import com.flj.config.MainConfigOfPropertyValues;
import com.flj.dao.BookDao;
import com.flj.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 17:23
 **/
public class IOCAutowiredTest {
    AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01(){
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
//        BookDao bean = applicationContext.getBean(BookDao.class);
//        System.out.println(bean);

        Boss bean = applicationContext.getBean(Boss.class);
        System.out.println(bean);

        Car bean1 = applicationContext.getBean(Car.class);
        System.out.println(bean1);

        Color bean2 = applicationContext.getBean(Color.class);
        System.out.println(bean2);
        Car bean3 = applicationContext.getBean(Car.class);
        System.out.println(bean3);

        applicationContext.close();


    }



}
