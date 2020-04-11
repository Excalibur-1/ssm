package com.gxl.controller;

import com.gxl.entity.Message;
import com.gxl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
  @Autowired
  private MessageService messageService;

  @RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
  public int deleteByPrimaryKey(Integer id) {
    return messageService.deleteByPrimaryKey(id);
  }

  @RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
  public int insert(@RequestBody Message record) {
    return messageService.insert(record);
  }

  @RequestMapping(value = "/insertSelectiveMessage", method = RequestMethod.POST)
  public int insertSelective(@RequestBody Message record) {
    return messageService.insertSelective(record);
  }

  @RequestMapping(value = "/selectMessage", method = RequestMethod.GET)
  public Message selectByPrimaryKey(Integer id) {
    return messageService.selectByPrimaryKey(id);
  }

  @RequestMapping(value = "/updateSelectiveMessage", method = RequestMethod.POST)
  public int updateByPrimaryKeySelective(@RequestBody Message record) {
    return messageService.updateByPrimaryKeySelective(record);
  }

  @RequestMapping(value = "/updateMessage", method = RequestMethod.POST)
  public int updateByPrimaryKey(@RequestBody Message record) {
    return messageService.updateByPrimaryKey(record);
  }

}
