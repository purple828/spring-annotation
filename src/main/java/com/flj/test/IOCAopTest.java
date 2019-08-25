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

        //测试时不能自己创建对象,切面只针对spring管理的对象,返回的MathCalculator对象是经过cglib增强后的代理对象，这个代理对象里面保存了详细信息（比如：增强器、目标对象等）
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1,0);

        applicationContext.close();


    }


}
