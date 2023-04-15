package com.scalar.design.lld.zerodha;

import com.scalar.design.lld.zerodha.enums.ExchangeValues;
import com.scalar.design.lld.zerodha.enums.OrderType;
import com.scalar.design.lld.zerodha.enums.TransactionType;
import com.scalar.design.lld.zerodha.models.Order;
import com.scalar.design.lld.zerodha.models.Stock;
import com.scalar.design.lld.zerodha.models.User;
import com.scalar.design.lld.zerodha.services.OrderExecutioner;
import com.scalar.design.lld.zerodha.services.OrderValidator;
import com.scalar.design.lld.zerodha.services.UserService;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class Zerodha {
  public static void main(String[] args) {
    User user = new User("tanaya");
    UserService.addUser(user.getUserId(), user);

    Stock stock = new Stock("TCS", 1000, ExchangeValues.NSE);

    Order order = new Order(OrderType.LIMIT,
        TransactionType.BUY, 1100, 20, stock, ExchangeValues.NSE);

    OrderValidator orderValidator = new OrderValidator();
    OrderExecutioner orderExecutioner = new OrderExecutioner();
    OrderManager orderManager = new OrderManager(orderValidator, orderExecutioner);

    orderManager.placeOrder(user.getUserId(), order);

  }
}
