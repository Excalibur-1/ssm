package com.gxl.service;

import com.gxl.entity.Temperature;

import java.util.List;

public interface TemperatureService {

  Temperature selectOne();

  List<Temperature> selectAll();

}
