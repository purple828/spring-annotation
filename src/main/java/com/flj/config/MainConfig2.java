package com.flj.config;

import com.flj.bean.Color;
import com.flj.bean.ColorFactoryBean;
import com.flj.bean.Person;
import com.flj.bean.Red;
import com.flj.condition.LinuxConditon;
import com.flj.condition.MyImportBeanDefinitionRegistrar;
import com.flj.condition.MyImportSelector;
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
//@Conditional({WindowsConditon.class})
@Import({Color.class,Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {


    /**
     *     //给容器中注册一个Bean,类型为返回值类型，id默认是方法名，但可以用@Bean属性修改
     *     @Scope : 调整作用域
     *     prototype    多实例，ioc容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会调用方法创建对象
     *     singleton    单实例（默认值），ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取就是直接从容器（map.get()）中拿
     *
     *      @Lazy    懒加载
     *
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

    /**
     * 给容器中注册组件的几种方式
     * 1）包扫描+组件标注注解（@Controller、@Service等等），但局限于自己写的类
     * 2）@Bean,导入的第三方包里面的组件
     * 3）@Import 快速给容器中导入一个组件
     *      1. @Import(要导入到容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
     *      2. ImportSelector:返回需要导入的组件的全类名数组
     *      3. ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）使用Spring提供的FactoryBean(工厂Bean)
     *      1. 默认获取到的是工厂bean调用getObject创建的对象
     *      2. 要获取工厂Bean本身，我们需要给id前面加一个&
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }



}
