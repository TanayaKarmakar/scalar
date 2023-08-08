package com.scalar.design.lld.lockermanagement.model;

import java.util.Date;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Slot {
  private final String slotId;
  private final Size size;
  private final Locker locker;
  private LockerItem lockerItem;
  private Date allocationDate;

  public Slot(String slotId, Size size, Locker locker) {
    this.slotId = slotId;
    this.size = size;
    this.locker = locker;
  }

  public String getSlotId() {
    return slotId;
  }

  public Size getSize() {
    return size;
  }

  public Locker getLocker() {
    return locker;
  }

  public LockerItem getLockerItem() {
    return lockerItem;
  }

  public Date getAllocationDate() {
    return allocationDate;
  }

  public synchronized boolean isAvailable() {
    return this.lockerItem == null;
  }

  synchronized public void deallocateSlot() {
    this.lockerItem = null;
  }

  public void allocatePackege(LockerItem lockerItem) {
  }
}
