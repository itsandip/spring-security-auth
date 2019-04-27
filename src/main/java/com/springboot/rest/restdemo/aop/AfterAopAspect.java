package com.springboot.rest.restdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterReturning(value = "execution(* com.springboot.rest.restdemo.service.*.*(..))", 
        returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }
    @After(value = "execution(* com.springboot.rest.restdemo.controller.*.*(..))")
   // @Around("com.springboot.rest.restdemo.aop.CommonJoinPointConfig.controllerLayerExecution()")    
    public void after(JoinPoint joinPoint) {
    	System.out.println("start-----------");
        logger.info("after execution of {}", joinPoint);
       /* logger.info("after execution of {}", joinPoint.getArgs());
        logger.info("after execution of {}", joinPoint.getTarget());
        logger.info("after execution of {}", joinPoint.getThis());
        logger.info("after execution of {}", joinPoint.getClass());
        logger.info("after execution of {}", joinPoint.getKind());
        logger.info("after execution of {}", joinPoint.getSignature());
        logger.info("after execution of {}", joinPoint.getSourceLocation());
        logger.info("after execution of {}", joinPoint.getStaticPart());*/
        System.out.println("end-----------");
        
    }
}
