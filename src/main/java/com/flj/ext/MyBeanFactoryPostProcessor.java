package com.flj.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author flj
 * @Description:
 * @date 2019-08-26 10:00
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        System.out.println("当前beanFactory中有"+count+"个Bean");
        System.out.println(Arrays.asList(names));
    }
}
