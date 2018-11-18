package com.godaiyun.upupup.pattern.template;

import java.sql.ResultSet;

public interface RowMapper<T> {

  T mapRow(ResultSet rs, int rowNum) throws Exception;
}