package com.scalar.design.adapter.external;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public class StripeAPI {
  public void pay(String email) {
    System.out.println("Making payment via Stripe");
  }

  public StripeStatus checkStatus(String paymentId) {
    return StripeStatus.OK;
  }
}
