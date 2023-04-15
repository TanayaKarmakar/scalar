package com.scalar.design.lld.zerodha.services;

import com.scalar.design.lld.zerodha.models.Order;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class ExchangeConnector {
  private static ExchangeConnector exchangeConnectorInstance;
  private static Lock lock = new ReentrantLock();

  private ExchangeConnector() {

  }

  public static ExchangeConnector getExchangeConnectorInstance() {
    if(exchangeConnectorInstance == null) {
      lock.lock();
      if(exchangeConnectorInstance == null)
        exchangeConnectorInstance = new ExchangeConnector();
      lock.unlock();
    }
    return exchangeConnectorInstance;
  }

  public void sendOrderToExchange(String userId, Order order) {
    System.out.println("Order is sent to Exchange");
  }
}
