package com.flj.test;

import com.flj.aop.MathCalculator;
import com.flj.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author flj
 * @Description:
 * @date 2019-08-16 17:07
 **/
public class IOCAopTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

        //测试时不能自己创建对象,切面只针对spring管理的对象
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(1,0);

        applicationContext.close();


    }


}
