package com.gxl.mapper;

import com.gxl.entity.Temperature;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureMapper {

  Temperature selectOne();

  List<Temperature> selectAll();
}