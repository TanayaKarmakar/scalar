package com.scalar.design.adapter.impl;

import com.scalar.design.adapter.external.RazorPayAPI;
import com.scalar.design.adapter.external.RazorPayStatus;
import com.scalar.design.adapter.interfaces.PaymentProvider;
import com.scalar.design.adapter.models.PaymentRequest;
import com.scalar.design.adapter.models.PaymentStatus;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public class RazorPayProvider implements PaymentProvider {
  private RazorPayAPI api;

  public RazorPayProvider(RazorPayAPI api) {
    this.api = api;
  }

  @Override
  public void createPayment(PaymentRequest req) {
    api.makePayment(req.getEmail(), req.getPhoneNumber());
  }

  @Override
  public PaymentStatus verifyStatus(String paymentId) {
    RazorPayStatus status = api.checkStatus(paymentId);
    return toStatus(status);
  }

  private PaymentStatus toStatus(RazorPayStatus status) {
    if(status == RazorPayStatus.SUCCESS)
      return PaymentStatus.SUCCESS;
    return PaymentStatus.ERROR;
  }
}
