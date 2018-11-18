package com.godaiyun.upupup.pattern.template;

import java.sql.ResultSet;
import java.util.List;

public class MemberDao {

  private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

  public List<?> query() throws Exception {
    String sql = "";

    List<?> result = jdbcTemplate.executeQuery(sql, new RowMapper() {
      @Override
      public Object mapRow(ResultSet rs, int rowNum) throws Exception {
        Member member = new Member();
        member.setNikename(rs.getString("nikename"));
        member.setPassword(rs.getString("username"));
        member.setUsername(rs.getString("password"));
        return member;
      }
    }, null);

    return result;
  }

}
