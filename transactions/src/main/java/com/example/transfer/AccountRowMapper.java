package com.example.transfer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

  @Override
  public Account mapRow(ResultSet rs, int i) throws SQLException {
    Account a = new Account();
    a.setId(rs.getInt("id"));
    a.setName(rs.getString("name"));
    a.setAmount(rs.getBigDecimal("amount"));
    return a;
  }
}
