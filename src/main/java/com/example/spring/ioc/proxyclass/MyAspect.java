package com.example.spring.ioc.proxyclass;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    //切入点表达式的抽象
    @Pointcut("execution(public void com.example.spring.ioc.proxyclass.UserController.*(..))")
    public void pointCut(){}

    //第1种切入点表达式用法：直接写方法表示调用本类的@Pointcut定义的切入点表达式
    @Before("pointCut()")
    public void BeforeUserBuy(JoinPoint joinPoint){ // 切入点
        Class declaringType = joinPoint.getSignature().getDeclaringType(); //切入点目标类
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();//切入点类名（全路径）
        Object aThis = joinPoint.getThis(); //切入点目标对象
        String name = joinPoint.getSignature().getName(); //切入点方法名
        Object[] args = joinPoint.getArgs(); //目标方法的参数
        String kind = joinPoint.getKind();// 切入点类型 方法切入
        System.out.println("user buy before");
    }
    //第2种切入点表达式用法：这个方法可以在其他类中调用 @Pointcut 定义的切入点表达式
    @After("com.example.spring.anno.aop.LogAspects.pointCut()")
    public void afterUserBuy(){
        System.out.println("user buy after");
    }
    //第3种切入点表达式用法：也可以直接写切入点表达式
    @AfterReturning("execution(public void com.example.spring.ioc.proxyclass.UserController.*(..))")
    public void returnAble(){
        System.out.println("user buy return");
    }
    @AfterThrowing("execution(public void com.example.spring.ioc.proxyclass.UserController.*(..))")
    public void exceptionAble(){
        System.out.println("user buy exception");
    }
/*    @Around("execution(public void com.example.spring.ioc.proxyclass.UserController.*(..))")
    public Object aroundAble(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("user buy before");
            Object[] args = proceedingJoinPoint.getArgs();
            Object proceed = proceedingJoinPoint.proceed(args);
            System.out.println("user buy after");
            return proceed;
        }catch (Throwable throwable) {
            System.out.println("user buy exception");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("user buy finally");
        }
    }*/
}
