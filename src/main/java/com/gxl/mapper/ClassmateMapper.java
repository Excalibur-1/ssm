package com.gxl.mapper;

import com.gxl.entity.Classmate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gxl
 */
@Repository
public interface ClassmateMapper {

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