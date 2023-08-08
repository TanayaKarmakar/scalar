package com.scalar.design.lld.lockermanagement.model;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public abstract class LockerUser {
  private Contact contact;

  public LockerUser(Contact contact) {
    this.contact = contact;
  }

  public Contact getContact() {
    return contact;
  }
}
