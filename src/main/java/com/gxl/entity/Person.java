package com.gxl.entity;

import java.io.Serializable;

/**
 * @author gxl
 */
public class Person implements Serializable {
  private Integer id;

  private boolean sex;

  private String country;

  private Integer classmateId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getClassmateId() {
    return classmateId;
  }

  public void setClassmateId(Integer classmateId) {
    this.classmateId = classmateId;
  }
}