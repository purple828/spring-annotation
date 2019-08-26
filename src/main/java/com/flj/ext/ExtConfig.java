package com.flj.ext;

import com.flj.bean.Car;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author flj
 * @Description:
 *          扩展原理：
 *          BeanPostProcessor:bean后置处理器，bean创建对象初始化前后进行拦截工作
 *
 *          1、
 *          BeanFactoryPostProcessor：beanFactory的后置处理器，在beanFactory标准初始化之后调用，
 *          所有的bean定义已经保存加载到beanFactory中，但是bean的实例还未创建
 *
 *          1）ioc容器创建对象
 *          2）invokeBeanFactoryPostProcessors(beanFactory),执行BeanFactoryPostProcessor;
 *              如何找到所有的BeanFactoryPostProcessor并执行他们的方法
 *                  1）直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *                  2）在初始化创建其他组件前面执行
 *
 *         2、
 *          BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *          postProcessBeanDefinitionRegistry();
 *          在所有bean定义信息将要被加载，bean实例还未创建的
 *          优先于BeanFactoryPostProcessor执行，利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件
 *          原理：
 *              1）ioc创建对象
 *              2）refresh()->invokeBeanFactoryPostProcessors(beanFactory)
 *              3) 从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件，
 *                  1) 依次触发所有的postProcessBeanDefinitionRegistry
 *                  2) 再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor
 *              4）再来从容器中找到BeanFactoryPostProcessor组件，然后依次触发postProcessBeanFactory()
 *
 *
 *          3、
 *          ApplicationListener,监听容器中发布的事件，事件驱动模型开发
 *              public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *              监听ApplicationEvent及其下面的子事件
 *
 *           步骤：
 *           1）写一个监听器来监听某个事件（ApplicationEvent及其下面的子事件）
 *              @EventListener
 *                  原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener
 *                  EventListenerMethodProcessor implements SmartInitializingSingleton
 *           2）把监听器加入到容器
 *           3）只要容器中有相关事件的发布，我们就能监听到这个事件
 *                  ContextRefreshedEvent，容器刷新完成（所有bean的完全创建）会发布这个事件
 *                  ContextClosedEvent，关闭容器会发布这个事件
 *           4）发布一个事件
 *                  applicationContext.publishEvent();
 *
 *           原理：
 *              ContextRefreshedEvent、IOCExtTest$1[source=我发布的事件！]、ContextClosedEvent
 *           1）ContextRefreshedEvent事件：
 *              1）容器创建对象：refresh()
 *              2）finishRefresh()：容器刷新完成，发布ContextRefreshedEvent事件
 *              3）publishEvent(new ContextRefreshedEvent(this))
 *                  事件发布流程：
 *                      1）获取事件的多播器（派发器），getApplicationEventMulticaster()
 *                      2）mulicasterEvent()派发事件
 *                      3）获取到所有的ApplicationListener,
 *                          如果有Executor,可以支持使用Executor进行异步派发
 *                          否则以同步的方式直接执行listener方法：invokelistener(listener,event)
 *                          拿到listener回调onApplicationEvent方法
 *
 *            事件多播器：
 *              1）容器创建对象，调用 refresh()
 *              2）initApplicationEventMulticaster(),初始化ApplicationEventMulticaster
 *                  初始化时先从容器中查找该对象，如果有直接返回，如果没有就手动加入到容器中，后续其他要派发组件事件自动注入
 *
 *
 *            容器中有那些监听器
 *              1）容器创建对象，调用 refresh()
 *              2）registerListeners()
 *                  从容器中拿到所有的监听器（所有ApplicationListener.class），把他们注册到事件多播器
 *
 *
 *            SmartInitializingSingleton原理：
 *            1）ioc容器创建对象并refresh()
 *            2）finishBeanFactoryInitialization(beanFatory),初始化剩下的单实例bean
 *              1)先创建所有的单实例bean:getBean()
 *              2)获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton
 *                  是：调用afterSingletonsInstantiated()
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @date 2019-08-26 09:50
 **/
@ComponentScan("com.flj.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Car car(){
//        ApplicationListener
        return new Car();
    }


}
