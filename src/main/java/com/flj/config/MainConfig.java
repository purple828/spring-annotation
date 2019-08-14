package com.flj.config;

import com.flj.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


/**
 * @author flj
 * @Description:配置类 == 配置文件
 * @date 2019-08-14 16:24
 *
 * componentScan  value :指定要扫描的包
 * excludeFilters = Fileter[] 指定扫描的时候按照什么规则排除哪些组件
 * includeFilters = Fileter[] 指定扫描的时候只要包含哪些组件
 *
 *
 **/
//告诉spring这是一个配置类
@Configuration
//@ComponentScan(value = "com.flj",excludeFilters = {
//        @Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//})
@ComponentScan(value = "com.flj",includeFilters = {
        @Filter(type= FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
//@ComponentScan(value = "com.flj")
public class MainConfig {


    /**
     *     //给容器中注册一个Bean,类型为返回值类型，id默认是方法名，但可以用@Bean属性修改
     * @return
     */
    @Bean
    public Person person(){
        return Person.builder().name("hello").age(18).build();
    }



}
