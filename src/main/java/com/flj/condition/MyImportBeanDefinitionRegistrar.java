package com.flj.condition;

import com.flj.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 11:53
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata    当前类的注解信息
     * @param registry    BeanDefinition注册类，把所有需要添加到容器中的bean调用
     *                    BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.flj.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.flj.bean.Blue");
        if(red && blue){
            //指定Bean定义信息（Bean的类型，Bean作用域Scope等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }

    }
}
