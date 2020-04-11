package com.gxl.service;

import com.gxl.entity.Person;
import com.gxl.entity.vo.PersonVO;

import java.util.List;

/**
 * @author gxl
 */
public interface PersonService {

  /**
   * 根据Id查询
   * @param id id
   * @return Person
   */
  Person selectByPrimaryKey(Integer id);

  /**
   * 查询所有
   * @return List<Person>
   */
  List<Person> selectAll();

  /**
   * 查询所有VO
   * @return List<PersonVO>
   */
  List<PersonVO> selectPersonVO();

}
