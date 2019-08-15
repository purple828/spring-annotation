package com.flj.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author flj
 * @Description:
 * @date 2019-08-15 11:34
 **/
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param annotationMetadata    当前标注@Import注解的类的所有注解信息
     * @return  返回值，就是要导入到容器的组件全类名
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {


        return new String[]{"com.flj.bean.Blue","com.flj.bean.Yellow"};
    }
}
