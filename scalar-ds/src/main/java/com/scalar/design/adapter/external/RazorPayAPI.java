package com.scalar.design.adapter.external;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public class RazorPayAPI {
  public void makePayment(String email, String phone) {
    System.out.println("Making payment via Razorpay");
  }

  public RazorPayStatus checkStatus(String paymentId) {
    return RazorPayStatus.SUCCESS;
  }
}
