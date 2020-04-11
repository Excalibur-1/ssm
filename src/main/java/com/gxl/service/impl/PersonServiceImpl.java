package com.gxl.service.impl;

import com.gxl.entity.Person;
import com.gxl.entity.vo.PersonVO;
import com.gxl.mapper.PersonMapper;
import com.gxl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gxl
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonMapper personMapper;

  @Override
  public Person selectByPrimaryKey(Integer id) {
    return personMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<Person> selectAll() {
    return personMapper.selectAll();
  }

  @Override
  public List<PersonVO> selectPersonVO() {
    return personMapper.selectPersonVO();
  }

}
