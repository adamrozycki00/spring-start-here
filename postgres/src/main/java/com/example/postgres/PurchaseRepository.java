package com.example.postgres;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

  private final JdbcTemplate jdbc;

  public PurchaseRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public void storePurchase(Purchase purchase) {
    String sql = "INSERT INTO purchase(product, price) VALUES (?, ?)";
    Object[] args = {purchase.getProduct(), purchase.getPrice()};
    jdbc.update(sql, args);
  }

  public List<Purchase> findAllPurchases() {
    String sql = "SELECT * FROM purchase";

    RowMapper<Purchase> purchaseRowMapper = (rs, i) -> {
      Purchase purchase = new Purchase();
      purchase.setId(rs.getInt("id"));
      purchase.setProduct(rs.getString("product"));
      purchase.setPrice(rs.getBigDecimal("price"));
      return purchase;
    };

    return jdbc.query(sql, purchaseRowMapper);
  }
}