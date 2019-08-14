package com.flj.test;

import com.flj.bean.Person;
import com.flj.config.MainConfig;
import com.flj.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

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

    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        for (String str : beanNamesForType){
            System.out.println(str);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");

        System.out.println(person1 == person2);

    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        for (String str : beanNamesForType){
            System.out.println(str);
        }
        //动态获取环境变量的值 ：Mac OS X
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);


        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);

        System.out.println(persons);
    }


}
