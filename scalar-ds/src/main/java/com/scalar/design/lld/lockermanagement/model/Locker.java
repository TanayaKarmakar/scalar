package com.scalar.design.lld.lockermanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Locker{
  private final String id;
  private final List<Slot> slots;

  public Locker(String id) {
    this.id = id;
    this.slots = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public List<Slot> getSlots() {
    return slots;
  }

  public void addSlot(final Slot slot) {
    this.slots.add(slot);
  }

  public List<Slot> getAvailableSlots() {
    return slots.stream().filter(Slot::isAvailable).collect(Collectors.toList());
  }
}
