package com.jb.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMoniterAspect.class);
    @Around("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..))")
    public Object moniterTime(ProceedingJoinPoint jp) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time Taken: "+ jp.getSignature().getName() +" : "+(end-start)+" ms");
        return obj;
    }
}
