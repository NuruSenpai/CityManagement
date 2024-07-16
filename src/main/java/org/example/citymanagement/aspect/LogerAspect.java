package org.example.citymanagement.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogerAspect {

    @Before(value = "@annotation(org.example.citymanagement.aspect.EnableLoger)", argNames = "joinPoint")
    public void log(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        log.info(args[0].getClass().getCanonicalName());
    }

    @AfterReturning(value = "@annotation(org.example.citymanagement.aspect.EnableLoger)", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        log.info("{}", result);

    }
}
