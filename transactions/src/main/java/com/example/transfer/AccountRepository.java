package com.example.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

  private final JdbcTemplate jdbc;
  private final AccountRowMapper rowMapper;

  @Autowired
  public AccountRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
    this.rowMapper = new AccountRowMapper();
  }

  public Account findAccountById(long id) {
    String sql = "SELECT * FROM account WHERE id = ?";
    return jdbc.queryForObject(sql, rowMapper, id);
  }

  public void changeAmount(long id, BigDecimal amount) {
    String sql = "UPDATE account SET amount = ? WHERE id = ?";
    jdbc.update(sql, amount, id);
  }

  public List<Account> findAllAccounts() {
    String sql = "SELECT * FROM account";
    return jdbc.query(sql, rowMapper);
  }
}
