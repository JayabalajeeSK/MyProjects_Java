package com.jb.spring_boot_rest.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.jb.spring_boot_rest.service.impl.JobServiceImplementation.*(..))") 
    public void logMethodCall() {
        LOGGER.info("Method Called");
    }
}