package com.flj.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 11:22
 **/
@Component
public class Red implements ApplicationContextAware , BeanNameAware , EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc:"+applicationContext);
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String s) {
        System.out.println("当前bean的名字："+s);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("你好${os.name}我是#{20*18}");
        System.out.println("解析的字符串:"+s);
    }
}
