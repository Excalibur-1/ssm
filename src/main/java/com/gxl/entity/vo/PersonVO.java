package com.gxl.entity.vo;

import java.io.Serializable;

/**
 * @author gxl
 */
public class PersonVO implements Serializable {

  private Integer id;

  private String name;

  private Integer age;

  private Boolean sex;

  private String country;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "ClassmateVO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        ", country='" + country + '\'' +
        '}';
  }
}
