package com.flj.ext;

import com.flj.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author flj
 * @Description:
 * @date 2019-08-26 10:52
 **/
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistry： Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanDefinitionRegistry...bean的数量："+beanDefinitionRegistry.getBeanDefinitionCount());
//        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Car.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("hello",beanDefinition);

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanFactory...bean的数量："+configurableListableBeanFactory.getBeanDefinitionCount());

    }
}
