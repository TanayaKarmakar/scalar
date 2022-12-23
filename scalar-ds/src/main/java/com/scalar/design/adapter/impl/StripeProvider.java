package com.scalar.design.adapter.impl;

import com.scalar.design.adapter.external.StripeAPI;
import com.scalar.design.adapter.external.StripeStatus;
import com.scalar.design.adapter.interfaces.PaymentProvider;
import com.scalar.design.adapter.models.PaymentRequest;
import com.scalar.design.adapter.models.PaymentStatus;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public class StripeProvider implements PaymentProvider {
  private StripeAPI api;

  public StripeProvider(StripeAPI api) {
    this.api = api;
  }

  @Override
  public void createPayment(PaymentRequest req) {
    api.pay(req.getEmail());
  }

  @Override
  public PaymentStatus verifyStatus(String paymentId) {
    StripeStatus status = api.checkStatus(paymentId);
    return toStatus(status);
  }

  private PaymentStatus toStatus(StripeStatus status) {
    if(status == StripeStatus.OK)
      return PaymentStatus.SUCCESS;
    return PaymentStatus.ERROR;
  }
}
