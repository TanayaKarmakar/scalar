package com.scalar.design.lld.zerodha;

import com.scalar.design.lld.zerodha.models.Order;
import com.scalar.design.lld.zerodha.services.OrderExecutioner;
import com.scalar.design.lld.zerodha.services.OrderValidator;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class OrderManager {
  private OrderValidator orderValidator;
  private OrderExecutioner orderExecutioner;

  public OrderManager(OrderValidator orderValidator, OrderExecutioner orderExecutioner) {
    this.orderValidator = orderValidator;
    this.orderExecutioner = orderExecutioner;
  }

  public void placeOrder(String userId, Order order) {
    if(orderValidator.validateOrder(userId, order)) {
      orderExecutioner.placeOrder(userId, order);
    }
  }
}
