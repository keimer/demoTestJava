package com.example.demo.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class MarcaImpAop {

    @Around("@annotation(marcaAop)")
    public Object printAnythink(final ProceedingJoinPoint proceedingJoinPoint, MarcaAop marcaAop) throws Throwable {
        log.info("Before method execution");
        Object result = proceedingJoinPoint.proceed();
        log.info("After method execution");
        return result;
    }

}