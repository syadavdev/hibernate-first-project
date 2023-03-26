package com.sandi.spring_transactional.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Datasource tracker : "+ proceedingJoinPoint.getSignature());
        final Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

}
