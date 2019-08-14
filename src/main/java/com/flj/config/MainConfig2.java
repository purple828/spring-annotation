package com.flj.config;

import com.flj.bean.Person;
import com.flj.condition.LinuxConditon;
import com.flj.condition.WindowsConditon;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;


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
@Configuration
//类中统一组件配置 满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowsConditon.class})
public class MainConfig2 {


    /**
     *     //给容器中注册一个Bean,类型为返回值类型，id默认是方法名，但可以用@Bean属性修改
     *     @Scope : 调整作用域
     *     prototype    多实例，ioc容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会调用方法创建对象
     *     singleton    单实例（默认值），ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取就是直接从容器（map.get()）中拿
     *
     *      @Lazy    懒加载
     * @return
     */

    @Scope
    @Bean("person")
    public Person person(){
        return Person.builder().name("张三").age(16).build();
    }

    /**
     * @Conditional({Condition}): 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows 给容器中注册（"bill"）,若为linux,则注册（"linus"）
     *
     */
    @Conditional({WindowsConditon.class})
    @Bean("bill")
    public Person person01(){
        return Person.builder().name("bill gates ").age(68).build();
    }

    @Conditional({LinuxConditon.class})
    @Bean("linus")
    public Person person02(){
        return Person.builder().name("linus").age(48).build();
    }



}
