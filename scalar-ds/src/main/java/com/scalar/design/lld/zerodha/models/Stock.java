package com.scalar.design.lld.zerodha.models;

import com.scalar.design.lld.zerodha.enums.ExchangeValues;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class Stock {
  private ExchangeValues exchange;
  private String name;
  private double value;

  public Stock(String name, double value, ExchangeValues exchange) {
    this.name = name;
    this.value = value;
    this.exchange = exchange;
  }

  public ExchangeValues getExchange() {
    return exchange;
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }
}
