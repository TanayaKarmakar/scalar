package com.scalar.design.lld.lockermanagement.controller;

import com.scalar.design.lld.lockermanagement.model.Buyer;
import com.scalar.design.lld.lockermanagement.model.DeliveryPerson;
import com.scalar.design.lld.lockermanagement.model.LockerItem;
import com.scalar.design.lld.lockermanagement.model.Slot;
import com.scalar.design.lld.lockermanagement.services.DeliveryPersonService;
import com.scalar.design.lld.lockermanagement.services.LockerService;
import com.scalar.design.lld.lockermanagement.services.NotificationService;
import com.scalar.design.lld.lockermanagement.services.OtpService;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class ReturnController {
  private final OtpService otpService;
  private final NotificationService notificationService;
  private final LockerService lockerService;
  private final DeliveryPersonService deliveryPersonService;

  public ReturnController(OtpService otpService,
                          NotificationService notificationService,
                          LockerService lockerService,
                          DeliveryPersonService deliveryPersonService) {
    this.otpService = otpService;
    this.notificationService = notificationService;
    this.lockerService = lockerService;
    this.deliveryPersonService = deliveryPersonService;
  }

  public void allocateLocker(final Buyer buyer, final LockerItem lockerItem) {
    final Slot slot = lockerService.allocateSlot(lockerItem);
    final String otp = otpService.generateOtp(slot);
    final DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(slot);
    notificationService.notifyUser(deliveryPerson, otp, slot);
  }
}
