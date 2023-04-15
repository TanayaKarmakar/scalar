package com.scalar.design.lld.zerodha.models;

import com.scalar.design.lld.zerodha.enums.ExchangeValues;
import com.scalar.design.lld.zerodha.enums.OrderType;
import com.scalar.design.lld.zerodha.enums.TransactionType;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class Order {
  private OrderType orderType;
  private TransactionType transactionType;
  private double price;
  private int quantity;
  private Stock stock;
  private ExchangeValues exchange;

  public Order(OrderType orderType, TransactionType transactionType, double price, int quantity,
               Stock stock, ExchangeValues exchange) {
    this.orderType = orderType;
    this.transactionType = transactionType;
    this.price = price;
    this.quantity = quantity;
    this.stock = stock;
    this.exchange = exchange;
  }

  public OrderType getOrderType() {
    return orderType;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public Stock getStock() {
    return stock;
  }

  public ExchangeValues getExchange() {
    return exchange;
  }
}
