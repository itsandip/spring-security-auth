package com.springboot.rest.restdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAOP {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
   @Before("execution(* com.springboot.rest.restdemo.controller.*.*(..)) || execution(* com.springboot.rest.restdemo.service.*.*(..))")    
   //@Before("execution(* com.springboot.rest.restdemo.service.*.*(..))")   
	//@Around("com.springboot.rest.restdemo.aop.CommonJoinPointConfig.controllerLayerExecution()")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Before Allowed execution for {}", joinPoint);
    }

}
