package com.scalar.design.lld.lockermanagement.services;

import com.scalar.design.lld.lockermanagement.model.LockerUser;
import com.scalar.design.lld.lockermanagement.model.Slot;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class NotificationService {
  public void notifyUser(LockerUser user, String otp, Slot slot) {
    System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slot);
  }
}
