package spring.core.aspect;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DrawAspect {

    @Pointcut("execution(* *.draw(..))")
    private void drawPointCut() {}

    @Pointcut("execution(* spring.core.di.Circle.draw(..))")
    private void circleDrawPointCut() {}

    @Before("drawPointCut()")
    public void beforeDraw() {
        System.out.println("Before draw method advice...");
    }

    @After("drawPointCut()")
    public void afterDraw() {
        System.out.println("After draw method advice...");
    }

    @AfterReturning("circleDrawPointCut()")
    public void afterCircleDraw() {
        System.out.println("After circle draw method returning advice...");
    }
    
}
