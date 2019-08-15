package com.flj.test;

import com.flj.bean.Person;
import com.flj.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 17:23
 **/
public class IOCPropertyValuesTest {
    AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){
        printBeans(applicationContext);
        System.out.println("---------------");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        applicationContext.close();


    }


    private void printBeans(ApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String str : beanDefinitionNames){
            System.out.println(str);
        }
    }


}
