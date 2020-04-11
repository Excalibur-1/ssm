package com.gxl.service;

import com.gxl.entity.Classmate;

import java.util.List;

/**
 * @author gxl
 */
public interface ClassmateService {


  /**
   * 根据id查询
   *
   * @param id id
   * @return Classmate
   */
  Classmate selectByPrimaryKey(Integer id);

  /**
   * 查询所有
   * @return List<Person>
   */
  List<Classmate> selectAll();

}
