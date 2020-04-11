package com.gxl.mapper;

import com.gxl.entity.WeatherInfo;
import com.gxl.utils.WeatherUtils;
import org.junit.Test;

public class WeatherUtilsTest {

  @Test
  public void getWeather() {
    String info = WeatherUtils.GetWeatherData("武汉");
    WeatherInfo weatherInfo = WeatherUtils.GetWeather(info);
    if (weatherInfo != null)
      System.out.println(weatherInfo.toString());
    else
      System.out.println("weatherInfo is null");
  }
}