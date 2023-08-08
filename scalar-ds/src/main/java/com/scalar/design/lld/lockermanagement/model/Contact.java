package com.scalar.design.lld.lockermanagement.model;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Contact {
  private String email;
  private String phoneNumber;

  public Contact(String email, String phoneNumber) {
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
