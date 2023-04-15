package com.scalar.design.lld.zerodha.services;

import com.scalar.design.lld.zerodha.enums.TransactionType;
import com.scalar.design.lld.zerodha.models.Order;
import com.scalar.design.lld.zerodha.models.User;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class OrderValidator {
  public boolean validateOrder(String userId, Order order) {
    User user = UserService.getUser(userId);

    if(order.getTransactionType() == TransactionType.BUY) {
      System.out.println("Checking if user has funds to buy ");
    } else {
      System.out.println("Checking if user has the stocks to sell");
    }
    System.out.println("Assuming user has made valid order");
    return true;
  }
}
