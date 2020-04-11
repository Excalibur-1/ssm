package com.gxl.entity;

import java.io.Serializable;

/**
 * @author gxl
 */
public class WeatherInfo implements Serializable {

  /**
   * 时间
   */
  private String date;

  /**
   * 城市名
   */
  private String cityName;

  /**
   * 天气
   */
  private String weather;

  /**
   * 气温
   */
  private String temperature;

  /**
   * 当前气温
   */
  private String currentTemperature;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getWeather() {
    return weather;
  }

  public void setWeather(String weather) {
    this.weather = weather;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public String getCurrentTemperature() {
    return currentTemperature;
  }

  public void setCurrentTemperature(String currentTemperature) {
    this.currentTemperature = currentTemperature;
  }

  @Override
  public String toString() {
    return "WeatherInfo{" +
        "date='" + date + '\'' +
        ", cityName='" + cityName + '\'' +
        ", weather='" + weather + '\'' +
        ", temperature='" + temperature + '\'' +
        ", currentTemperature='" + currentTemperature + '\'' +
        '}';
  }
}
