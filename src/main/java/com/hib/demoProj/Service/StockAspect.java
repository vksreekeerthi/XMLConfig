package com.hib.demoProj.Service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class StockAspect {

    @Before("execution(* com.hib.demoProj.Service.StockService.*(..))")
    public void display()
    {
        System.out.println("Calling BeforeAspect method before execution");
    }
    @After("execution(* com.hib.demoProj.Service.StockService.*(..))")
    public void displayafter()
    {
        System.out.println("Calling AfterAspect method before execution");
    }

}
