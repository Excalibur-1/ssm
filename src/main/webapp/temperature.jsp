<%@ page pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<HTML>
<HEAD>
  <TITLE>采集数据</TITLE>
  <script type="text/javascript">
    // 每1秒钟 运行一次，发送一个 ajax 请求
    function runEvery10Sec() {
      if (document.getElementById("stop").innerText === '已停止请求') {
        return;
      }
      // 1000 * 10 = 10 秒钟
      setTimeout( runEvery10Sec, 1000 );
      loadXMLDoc1();
      loadXMLDoc2();
    }
    function loadXMLDoc1() {
      var xmlHttp;
      if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp=new XMLHttpRequest();
      } else {// code for IE6, IE5
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlHttp.onreadystatechange=function() {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
        {
          var obj = eval('('+ xmlHttp.responseText +')');
          f1(obj.centigrade, obj.fahrenheit);
        }
      };
      xmlHttp.open("GET","http://192.168.1.102:8080/getCurrentTemperature",true);
      xmlHttp.send();
    }
    function loadXMLDoc2() {
      var xmlHttp;
      if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp=new XMLHttpRequest();
      } else {// code for IE6, IE5
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlHttp.onreadystatechange=function() {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
        {
          f2(xmlHttp.responseText);
        }
      };
      xmlHttp.open("GET","http://192.168.1.102:8080/getCurrentHeartRate",true);
      xmlHttp.send();
    }
    function f1(value1, value2) {
      var _t = document.getElementById("table1");
      _t.innerHTML += '<tr><td style="background:#FFF">' + value1 + '</td><td style="background:#FFF">' + value2 + '</td></tr>'
    }
    function f2(value) {
      var _t = document.getElementById("table2");
      _t.innerHTML += '<tr><td style="background:#FFF">' + value + '</td></tr>'
    }
    function stop() {
      document.getElementById("stop").innerText = '已停止请求';
    }
  </script>
  <style>
    div{ float:left}
  </style>
</HEAD>
<BODY onload="runEvery10Sec()">
<div>
  <div>
    <table style="background:#CCC; color:#F00" cellspacing="10px" width="300px" border="1" id="table1">
      <tr>
        <th>温度(单位：℃)</th>
        <th>温度(单位：℉)</th>
      </tr>
    </table>
  </div>
  <div>
    <table style="background:#CCC; color:#F00" cellspacing="10px" width="300px" border="1" id="table2">
      <tr>
        <th>心率(单位：次/分钟)</th>
      </tr>
    </table>
  </div>
  <button style="border:1px solid #FF9933 ; background-color:#A19F4F" id="stop" onclick="stop()">停止请求</button>
</div>
</BODY>
</HTML>