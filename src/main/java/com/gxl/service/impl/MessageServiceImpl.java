package com.gxl.service.impl;

import com.gxl.entity.Message;
import com.gxl.mapper.MessageMapper;
import com.gxl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
  @Autowired
  private MessageMapper messageMapper;

  public int deleteByPrimaryKey(Integer id) {
    return messageMapper.deleteByPrimaryKey(id);
  }

  public int insert(Message record) {
    return messageMapper.insert(record);
  }

  public int insertSelective(Message record) {
    return messageMapper.insertSelective(record);
  }

  public Message selectByPrimaryKey(Integer id) {
    return messageMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Message record) {
    return messageMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(Message record) {
    return messageMapper.updateByPrimaryKey(record);
  }
}
