package com.godaiyun.upupup.pattern.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

  private DataSource dataSource;

  public JdbcTemplate(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  private Connection getConnection() throws Exception {
    return this.dataSource.getConnection();
  }

  private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
    return conn.prepareStatement(sql);
  }

  private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws Exception {
    for (int i = 0; i < values.length; i++) {
      pstmt.setObject(i, values[i]);
    }
    return pstmt.executeQuery();
  }


  private List<?> parseReuslt(ResultSet re, RowMapper rowMapper) throws Exception {
    List<Object> result = new ArrayList<Object>();
    int rowNum = 0;
    while (re.next()) {
      result.add(rowMapper.mapRow(re, rowNum++));
    }
    return result;
  }

  private void closeStatement(Statement stmt) throws Exception {
    stmt.close();
  }

  private void claseResult(ResultSet rs) throws Exception {
    rs.close();
  }

  private void closeConnection(Connection conn) throws Exception {

  }

  public List<?> executeQuery(String sql, RowMapper rowMapper, Object[] values) throws Exception {

    try {
      // 1.获取连接
      Connection conn = this.getConnection();

      // 2.创建语句集
      PreparedStatement pstmt = this.createPreparedStatement(conn, sql);

      // 3.执行语句集，并获取结果集
      ResultSet re = this.executeQuery(pstmt, values);

      // 4.解析语句集

      List<?> result = parseReuslt(re, rowMapper);

      // 5.关闭结果集
      this.claseResult(re);

      // 6.关闭语句集
      this.closeStatement(pstmt);

      // 7.关闭连接
      conn.close();

      return result;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
