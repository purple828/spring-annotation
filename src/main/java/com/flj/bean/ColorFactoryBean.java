package com.flj.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 14:23
 **/
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * true:这个bean是单实例，在容器中保存一份
     * false:多实例，每次获取都会创建一个bean
     * @return
     */
    public boolean isSingleton() {
        return false;
    }
}
