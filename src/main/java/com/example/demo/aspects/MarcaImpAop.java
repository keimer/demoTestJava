package com.example.demo.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class MarcaImpAop {

    @After("@annotation(MarcaAop)")
    public void printAnythinkAfter(final JoinPoint joinPoint, MarcaAop marcaAop) {
        log.info("Log transaccional salida.");
    }

    @Before("@annotation(MarcaAop)")
    public void printAnythinkEnd(final JoinPoint joinPoint, MarcaAop marcaAop) {
        log.info("Log transaccional entrada. " + joinPoint.getArgs().toString());
    }
}
