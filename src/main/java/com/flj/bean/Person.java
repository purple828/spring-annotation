package com.flj.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    /**
     * 使用@Value赋值
     * 1、基本数值
     * 2、可以写SpEL,#{}
     * 3、可以写${} ,取出配置文件【properties】中的值（在运行环境变量的值）
     */
    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;




}
