package com.jb.spring_boot_rest.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..)) || com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getJob(..))") 
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..)) || execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..))") 
    public void logMethodExecution(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..)) || execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..))") 
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issue  " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..)) || execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.getAllJobs(..))") 
    public void logMethodExecutedSuccessfully(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully  " + jp.getSignature().getName());
    }
}