package com.flj.test;

import com.flj.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author flj
 * @Description:
 * @date 2019-08-16 15:05
 **/
public class IOCProfilesTest {

    @Test
    public void test01(){
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
//
//        for (String str : beanNamesForType){
//            System.out.println(str);
//        }
//        applicationContext.close();

        //1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);

        for (String str : beanNamesForType){
            System.out.println(str);
        }
        applicationContext.close();


    }


}
