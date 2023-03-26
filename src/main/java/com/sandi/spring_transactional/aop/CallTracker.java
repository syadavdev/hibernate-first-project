package com.sandi.spring_transactional.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracker {

    @Pointcut("within(com..service.*) || within(com..repository.*)")
    public void logMethodPointCut(){

    }

    /*@Before("logMethodPointCut()")
    public void logBeforeMethodCall(){
        System.out.println("method is starting...");
    }

    @After("logMethodPointCut()")
    public void logAfterMethodCall(){
        System.out.println("method is ending...");
    }
*/

    @Around("logMethodPointCut()")  //combination of both Before, After
    public void logBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("method started " + proceedingJoinPoint.getSignature().getName());
        final Object proceed = proceedingJoinPoint.proceed();
        System.out.println(proceed);
        System.out.println("method ended " + proceedingJoinPoint.getSignature().getName());

    }
}
