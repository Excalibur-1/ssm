package com.gxl.controller;

import com.gxl.entity.vo.PersonVO;
import com.gxl.service.ClassmateService;
import com.gxl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gxl
 */
@RestController
public class ClassmateController {

  @Autowired
  private ClassmateService classmateService;

  @Autowired
  private PersonService personService;

  @RequestMapping(value = "/selectPerson", method = RequestMethod.GET)
  public List<PersonVO> selectPerson() {
    long begin = System.currentTimeMillis();
    /*List<Person> people = personService.selectAll();
    List<PersonVO> list = new LinkedList<>();
    for (Person person : people) {
      PersonVO personVO = new PersonVO();
      BeanUtils.copyProperties(person, personVO);
      Classmate classmate = classmateService.selectByPrimaryKey(person.getClassmateId());
      personVO.setName(classmate == null ? "" : classmate.getName());
      personVO.setAge(classmate == null ? 19 : classmate.getAge());
      list.add(personVO);
    }*/
    List<PersonVO> list = personService.selectPersonVO();
    long end = System.currentTimeMillis();
    System.out.println(end - begin);

    return list;
  }
}
