package com.scalar.design.adapter.interfaces;

import com.scalar.design.adapter.models.PaymentRequest;
import com.scalar.design.adapter.models.PaymentStatus;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public interface PaymentProvider {
  void createPayment(PaymentRequest req);

  PaymentStatus verifyStatus(String paymentId);
}
