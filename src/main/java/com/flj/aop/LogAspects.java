package com.flj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author flj
 * @Description:切面类
 * @date 2019-08-16 16:27
 **/
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public int com.flj.aop.MathCalculator.*(..))")
    public void pointCut(){};

    /**
     * @Before 在目标方法之前切入；切入点表达式（指定在哪个方法插入）
     */
//    @Before("public int com.flj.aop.MathCalculator.*(...)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("方法"+joinPoint.getSignature().getName()+"运行。。。@Before 参数列表是："+ Arrays.asList(args) +"");
    }

    @After("com.flj.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("方法"+joinPoint.getSignature().getName()+"除法结束。。。@After");
    }

    /**
     * JoinPoint 一定要出现在参数列表的第一位
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint , Object result){
        System.out.println("方法"+joinPoint.getSignature().getName()+"除法正常返回。。。@AfterReturning运行结果:{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint , Exception exception){
        System.out.println("方法"+joinPoint.getSignature().getName()+"除法异常。。。异常信息:{"+exception+"}");
    }

}
