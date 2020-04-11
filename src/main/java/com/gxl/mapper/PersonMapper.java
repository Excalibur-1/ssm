package com.gxl.mapper;

import com.gxl.entity.Person;
import com.gxl.entity.vo.PersonVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gxl
 */
@Repository
public interface PersonMapper {

  /**
   * 根据id查询
   *
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