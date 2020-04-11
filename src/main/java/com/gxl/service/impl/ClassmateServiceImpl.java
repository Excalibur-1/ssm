package com.gxl.service.impl;

import com.gxl.entity.Classmate;
import com.gxl.mapper.ClassmateMapper;
import com.gxl.service.ClassmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gxl
 */
@Service
public class ClassmateServiceImpl implements ClassmateService {

  @Autowired
  private ClassmateMapper classmateMapper;

  @Override
  public Classmate selectByPrimaryKey(Integer id) {
    return classmateMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<Classmate> selectAll() {
    return classmateMapper.selectAll();
  }

}
