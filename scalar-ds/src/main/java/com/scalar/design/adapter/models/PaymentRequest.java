package com.scalar.design.adapter.models;

/**
 * @author t0k02w6 on 22/12/22
 * @project scalar-ds
 */
public class PaymentRequest {
  private String phoneNumber;
  private String email;
  private String name;

  private PaymentRequest() {

  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public static class PaymentRequestBuilder {
    private String phoneNumber;
    private String email;
    private String name;

    public PaymentRequestBuilder() {

    }

    public PaymentRequestBuilder withPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public PaymentRequestBuilder withEmail(String email) {
      this.email = email;
      return this;
    }

    public PaymentRequestBuilder withName(String name) {
      this.name = name;
      return this;
    }

    public PaymentRequest build() {
      PaymentRequest req = new PaymentRequest();
      req.phoneNumber = this.phoneNumber;
      req.email = this.email;
      req.name = this.name;
      return req;
    }
  }
}
