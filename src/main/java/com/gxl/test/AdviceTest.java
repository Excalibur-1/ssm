package com.gxl.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author gxl
 */
@Aspect
@Component
public class AdviceTest {

  @Pointcut("@annotation(com.gxl.test.aop.Timer)")
  public void pointCut() {
  }

  @Before("pointCut()")
  public void before() {
    System.out.println("===before执行了===");
  }

}
