package com.scalar.design.lld.lockermanagement.strategies;

import com.scalar.design.lld.lockermanagement.model.LockerItem;
import com.scalar.design.lld.lockermanagement.model.Slot;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class SlotFilteringStrategySizeBased implements ISlotFilteringStrategy {
  @Override
  public List<Slot> filterSlots(List<Slot> slots, LockerItem lockerItem) {
    return slots.stream()
        .filter(slot -> slot.getSize().canAccommodate(lockerItem.getSize()))
        .collect(Collectors.toList());
  }
}
