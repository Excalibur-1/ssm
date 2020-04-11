package com.gxl.mapper;

import com.gxl.entity.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MessageMapperTest {

  private ApplicationContext applicationContext;

  @Autowired
  private MessageMapper messageMapper;

  @Before
  public void setUp() throws Exception {
    // 加载spring配置文件
    applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    // 导入需要测试的
    messageMapper = applicationContext.getBean(MessageMapper.class);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void insert() {
    Message message = new Message();
    message.setCommand("学习");
    message.setContent("休息");
    message.setDescription("玩游戏");
    int result = messageMapper.insert(message);
    System.out.println(result);
    assert  (result == 1);
  }
}