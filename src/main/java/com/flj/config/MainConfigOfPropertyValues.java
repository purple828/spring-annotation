package com.flj.config;

import com.flj.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author flj
 * @Description:
 * //使用@PropertySource读取外部配置文件中的属性k/v保存到运行的环境变量中,加载完外部配置文件后使用${}取出配置文件的值
 * @date 2019-08-15 17:21
 **/
@Configuration
@PropertySource(value = {"classpath:/person.properties"})
@PropertySources(value = {@PropertySource(value = {"classpath:/person.properties"}),@PropertySource(value = {"classpath:/person.properties"})})
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }

}
