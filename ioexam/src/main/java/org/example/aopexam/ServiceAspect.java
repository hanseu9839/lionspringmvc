package org.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(* org.example.aopexam.SimpleService.*(..))")
    public void pc() {

    }

    @Pointcut("execution(* hello())")
    public void pc2(){

    }

    // .. 매개변수 타입도 상관없음.
    @Before("pc()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before ::::::::::: " + joinPoint.getSignature().getName());
    }

    @After("pc2()")
    public void after(){
        System.out.println("After ::::::::::: ");
    }

    @AfterReturning(pointcut= "execution(* org.example.aopexam.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result){
        System.out.println("After method: " + joinPoint.getSignature().getName() + ", return value: " + result);
    }
}
