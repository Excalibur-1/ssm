package com.gxl.mapper;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

  @Test
  public void jdbcInsert() {
    Connection conn = null;
    PreparedStatement pstm = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/health?rewriteBatchedStatements=true";
      String user = "gxl";
      String password = "123456";
      conn = DriverManager.getConnection(url, user, password);
      String sql = "INSERT INTO classmate(id,name,age) VALUES(null,?,?)";
      pstm = conn.prepareStatement(sql);
      long start = System.currentTimeMillis();
      for (int i = 0; i < 2000000; i++) {
        pstm.setString(1, "love");
        pstm.setInt(2, 18);
        pstm.addBatch();
      }
      pstm.executeBatch();
      long end = System.currentTimeMillis();
      System.out.println("用时：" + (end - start));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (pstm != null) {
        try {
          pstm.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}