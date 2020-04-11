package com.gxl.service.impl;

import com.gxl.entity.Temperature;
import com.gxl.mapper.TemperatureMapper;
import com.gxl.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

  @Autowired
  private TemperatureMapper temperatureMapper;

  @Override
  public Temperature selectOne() {
    return temperatureMapper.selectOne();
  }

  @Override
  public List<Temperature> selectAll() {
    return temperatureMapper.selectAll();
  }
}
