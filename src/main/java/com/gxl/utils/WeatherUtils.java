package com.gxl.utils;

import com.gxl.entity.WeatherInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class WeatherUtils {

  /**
   * 通过城市名称获取该城市的天气信息
   *
   * @param cityName 城市名称
   * @return string
   */
  public static String GetWeatherData(String cityName) {
    StringBuilder sb = new StringBuilder();
    try {
      String weather_url = "http://wthrcdn.etouch.cn/weather_mini?city=" + cityName;
      URL url = new URL(weather_url);
      URLConnection conn = url.openConnection();
      InputStream is = conn.getInputStream();
      GZIPInputStream gzin = new GZIPInputStream(is);
      InputStreamReader isr = new InputStreamReader(gzin, "utf-8"); // 设置读取流的编码格式，自定义编码
      BufferedReader reader = new BufferedReader(isr);
      String line;
      while ((line = reader.readLine()) != null)
        sb.append(line).append(" ");
      reader.close();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }


  /**
   * 将JSON格式数据进行解析 ，返回一个weather对象
   *
   * @param weatherInfoByJson json数据
   * @return 天气对象
   */
  public static WeatherInfo GetWeather(String weatherInfoByJson) {
    JSONObject dataOfJson = JSONObject.fromObject(weatherInfoByJson);
    if (dataOfJson.getInt("status") != 1000)
      return null;

    //创建WeatherInfo对象，提取所需的天气信息
    WeatherInfo weatherInfo = new WeatherInfo();

    //从json数据中提取数据
    String data = dataOfJson.getString("data");
    dataOfJson = JSONObject.fromObject(data);
    weatherInfo.setCityName(dataOfJson.getString("city"));


    //获取预测的天气预报信息
    JSONArray forecast = dataOfJson.getJSONArray("forecast");
    //取得当天的
    JSONObject result = forecast.getJSONObject(0);
    weatherInfo.setDate(result.getString("date"));
    weatherInfo.setCurrentTemperature(dataOfJson.getString("wendu"));
    String high = result.getString("high").substring(2);
    String low = result.getString("low").substring(2);
    weatherInfo.setTemperature(low + "~" + high);
    weatherInfo.setWeather(result.getString("type"));
    return weatherInfo;
  }

}
