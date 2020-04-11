package com.gxl.test;

import org.springframework.stereotype.Component;

/**
 * @author gxl
 */
@Component
public class Chinese implements Person {

  @Override
  public void sayHello(String name) {
    System.out.println("===sayHello()执行===");
  }

  /**
   * 吃东西
   *
   * @param food 食物
   */
  public void eat(String food) {
    System.out.println("我正在吃：" + food);
  }

}
