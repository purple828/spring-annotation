package com.flj.config;

import com.flj.aop.LogAspects;
import com.flj.aop.MathCalculator;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author flj
 * @Description:    AOP【动态代理】:
 *                      指能在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *                      1、导入aop模块，Spring AOP(spring-aspects)
 *                      2、定义一个业务逻辑类（MathCalculator）,
 *                      在业务逻辑运行的时候将日志进行打印（方法之前，方法运行结束，方法异常等）
 *                      3、定义一个日志切面类（LogAspects）,切面类里面的方法需要动态感知MathCalculator.div运行到哪里
 *                          通知方法：
 *                          前置通知(@Before)：logStart   在目标方法（div）运行之情运行
 *                          后置通知(@After)：logEnd  在目标方法（div）运行结束之后运行(无论方法正常结束还是异常结束)
 *                          返回通知(@AfterReturning)：logReturn 在目标方法（div）正常返回之后运行
 *                          异常通知(@AfterThrowing)：logException 在目标方法（div）出现异常以后运行
 *                          环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.proceed()）
 *                      4、给切面类的目标方法标注何时何地运行（通知注解）
 *                      5、将切面类和业务逻辑类（目标方法所在类）都加入容器中
 *                      6、必须告诉Spring哪个类是切面类（给切面类加上注解:@Aspect）
 *                      7、给配置类加 @EnableAspectJAutoProxy（开启基于注解的AOP模式）
 *                          在spring中有很多@Enable***,作用都是开启某一项功能
 *
 *                      主要三步：
 *                      1、将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类（@Aspect）
 *                      2、在切面类的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *                      3、开启基于注解的AOP模式（@EnableAspectJAutoProxy）
 *
 *           AOP原理：@EnableAspectJAutoProxy（看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么）
 *           1、@EnableAspectJAutoProxy是什么？
 *              @Import(AspectJAutoProxyRegistrar.class)：给容器中导入AspectJAutoProxyRegistrar，
 *              利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *              给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *              internalAutoProxyCreator(bean的id)=AnnotationAwareAspectJAutoProxyCreator
 *
 *           2、AnnotationAwareAspectJAutoProxyCreator
 *                  AnnotationAwareAspectJAutoProxyCreator
 *                      ->AspectJAwareAdvisorAutoProxyCreator
 *                          ->AbstractAdvisorAutoProxyCreator
 *                              ->AbstractAutoProxyCreator
 *                                  ->extends ProxyProcessorSupport implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                                  关注后置处理器（在bean初始化完成前后做事情）、自动装配BeanFactory
 *
 *               AbstractAutoProxyCreator.setBeanFactory
 *               AbstractAutoProxyCreator.有后置处理器的逻辑
 *
 *               AbstractAdvisorAutoProxyCreator.setBeanFactory -> initBeanFactory
 *               AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *
 *               流程：
 *               1、传入配置类创建IOC容器
 *               2、注册配置类，调用refresh()刷新容器
 *               3、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *                  1) 先获取ioc容器中已经定义了的需要创建对象的所有BeanPostProcessor
 *                  2) 给容器中加别的BeanPostProcessor
 *                  3) 优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *                  4) 再给容器中实现了Ordered接口的BeanPostProcessor
 *                  5）注册没有实现优先级接口的BeanPostProcessor
 *                  6）注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *                  7）把BeanPostProcessor注册到BeanFactory中
 *
 *               ==================以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程==============================
 *
 *              AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】在所有bean创建之前会有一个拦截
 *              作用：每一个bean创建之前，调用postProcessBeforeInstantiation()
 *
 *              拦截器链：每一个通知方法又被包装为方法拦截器，利用MethodInterceptor机制
 *
 *总结：
 *      1）@EnableAspectJAutoProxy，开启AOP功能
 *      2）@EnableAspectJAutoProxy,会给容器中注册一个组件AnnotationAwareAspectJAutoProxyCreator
 *      3）会给容器中注册一个组件AnnotationAwareAspectJAutoProxyCreator是一个后置处理器
 *      4）容器的创建流程
 *          1）registerBeanPostProcessors() 注册后置处理器，创建AnnotationAwareAspectJAutoProxyCreator对象
 *          2）finishBeanFactoryInitialization()初始化剩下的单实例bean
 *              1)创建业务逻辑组件和切面组件
 *              2）AnnotationAwareAspectJAutoProxyCreator拦截组件的创建过程
 *              3）组件创建完后，判断组件是否需要增强
 *                  是：切面的通知方法包装成增强器（Advisor），给业务逻辑组件创建一个代理对象（cglib）
 *      5）执行目标方法
 *          1）代理对象执行目标方法
 *          2）CglibAopProxy.intercept():
 *              1)得到目标方法的拦截器链（增强器包装成拦截器MethodInterceptor）
 *              2)利用拦截器的链式机制，依次进入每一个拦截器进行执行
 *              3）效果：
 *                  正常执行：前置通知-》目标方法-》后置通知-》返回通知
 *                  出现异常：前置通知-》目标方法-》后置通知-》异常通知
 *
 *
 *
 *
 * @date 2019-08-16 16:19
 **/
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {


    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }



}
