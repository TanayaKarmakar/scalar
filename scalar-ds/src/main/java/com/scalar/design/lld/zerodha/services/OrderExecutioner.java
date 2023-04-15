package com.scalar.design.lld.zerodha.services;

import com.scalar.design.lld.zerodha.models.Order;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class OrderExecutioner {
  private ExchangeConnector exchangeConnector;

  public OrderExecutioner() {
    this.exchangeConnector = ExchangeConnector.getExchangeConnectorInstance();
  }

  public void placeOrder(String userId, Order order) {
    this.exchangeConnector.sendOrderToExchange(userId, order);
  }
}
