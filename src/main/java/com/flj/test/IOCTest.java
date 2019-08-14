package com.flj.test;

import com.flj.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:47
 **/
public class IOCTest {

    @SuppressWarnings("resource")
    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        for (String str : beanNamesForType){
            System.out.println(str);
        }

    }

}
