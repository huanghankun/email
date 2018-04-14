package com.email.aop.proxy;

import com.email.aop.model.AopLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Configuration
@Aspect
public class AopLogProxy {
    @Around("@annotation(com.email.aop.model.AopLog)")
    public Object printLog(ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
    //获取被代理方法的类名
        String className = signature.getDeclaringTypeName();
        System.out.println("被代理方法的类名:"+ className);
    //获取被代理的方法名
        Method method = signature.getMethod();
        System.out.println("被代理的方法名:"+ method.getName());
        AopLog annotation = method.getAnnotation(AopLog.class);
        System.out.println("------------"+annotation.funModule()+"------------");
        System.out.println( annotation.before());

        Object proceed = point.proceed();
        System.out.println("被代理的方法参数:"+ proceed);
        System.out.println( annotation.after());
        return proceed;
    }
} 