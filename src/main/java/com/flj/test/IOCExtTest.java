package com.flj.test;

import com.flj.ext.ExtConfig;
import com.flj.tx.TxConfig;
import com.flj.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author flj
 * @Description:
 * @date 2019-08-25 18:52
 **/
public class IOCExtTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
       applicationContext.close();

    }

}
