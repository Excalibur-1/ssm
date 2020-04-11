package com.gxl.controller;

import com.gxl.entity.Temperature;
import com.gxl.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemperatureController {

  @Autowired
  private TemperatureService temperatureService;

  @RequestMapping(value = "/getCurrentTemperature", method = RequestMethod.GET)
  public Temperature getCurrentTemperature() {
    Temperature temperature = temperatureService.selectOne();
    if (temperature == null) {
      return null;
    }
    return temperature;
  }

  @RequestMapping(value = "/getTemperatureList", method = RequestMethod.GET)
  public List<Temperature> getTemperatureList() {
    List<Temperature> temperatureList = temperatureService.selectAll();
    if (temperatureList == null || temperatureList.isEmpty()) {
      return null;
    }
    return temperatureList;
  }

  @RequestMapping(value = "/getCurrentHeartRate", method = RequestMethod.GET)
  public Integer getCurrentHeartRate() {
    List<Integer> rateList = getRateList();
    int total = 0;
    for (Integer rate : rateList) {
      total += rate;
    }
    return total/rateList.size();
  }

  @RequestMapping(value = "/getHeartRateList", method = RequestMethod.GET)
  public List<Integer> getHeartRateList() {
    return getRateList();
  }

  private List<Integer> getRateList() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int heartRate = getHeartRate();
      list.add(heartRate);
    }
    return list;
  }

  /**
   * 每分钟向服务器上传数据
   */
//  @Scheduled(cron = "0 */1 * * * ?")
  public void autoPushData() {
    Connection conn = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://120.79.206.182:3306/HealthData", "guanxiaolei", "Wufang2019+.");
      stmt = conn.createStatement();
      Temperature temperature = this.getCurrentTemperature();
      String centigrade = temperature.getCentigrade();
      Integer currentHeartRate = this.getCurrentHeartRate();
      int i = stmt.executeUpdate("update healthdata set heartrate = '" + currentHeartRate + "', sugarblood = '" + centigrade + "' where username = '13237131458'");
      if (i > 0) {
        System.out.println("上传数据成功!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 释放资源
      try{
        if (stmt != null)
          stmt.close();
        if (conn != null)
          conn.close();
      }catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  private int getHeartRate() {
    int random = (int) (Math.random() * 60) + 50;
    if (random < 75 || random > 85) {
      return getHeartRate();
    }
    return random;
  }

}