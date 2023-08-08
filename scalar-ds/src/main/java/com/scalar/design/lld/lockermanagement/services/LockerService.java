package com.scalar.design.lld.lockermanagement.services;

import com.scalar.design.lld.lockermanagement.exception.NoSlotAvailableException;
import com.scalar.design.lld.lockermanagement.model.Locker;
import com.scalar.design.lld.lockermanagement.model.LockerItem;
import com.scalar.design.lld.lockermanagement.model.Size;
import com.scalar.design.lld.lockermanagement.model.Slot;
import com.scalar.design.lld.lockermanagement.repository.ILockerRepository;
import com.scalar.design.lld.lockermanagement.strategies.ISlotAssignmentStrategy;
import com.scalar.design.lld.lockermanagement.strategies.ISlotFilteringStrategy;
import java.util.List;
import java.util.UUID;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class LockerService {
  private final ILockerRepository lockerRepository;
  private final ISlotFilteringStrategy slotFilteringStrategy;
  private final ISlotAssignmentStrategy slotAssignmentStrategy;


  public LockerService(final ILockerRepository lockerRepository, ISlotFilteringStrategy slotFilteringStrategy,
                       ISlotAssignmentStrategy slotAssignmentStrategy) {
    this.lockerRepository = lockerRepository;
    this.slotFilteringStrategy = slotFilteringStrategy;
    this.slotAssignmentStrategy = slotAssignmentStrategy;
  }

  public Locker createLocker(String lockerId) {
    return lockerRepository.createLocker(lockerId);
  }

  public Slot createSlot(final Locker locker, final Size slotSize) {
    final Slot slot = new Slot(UUID.randomUUID().toString(), slotSize, locker);
    locker.addSlot(slot);
    return slot;
  }


  public List<Slot> getAllAvailableSlots() {
    return lockerRepository.getAllAvailableSlots();
  }

  public void deallocateSlot(Slot slot) {
    slot.deallocateSlot();
  }

  public Slot allocateSlot(LockerItem lockerItem) {
    final List<Slot> allAvailableSlots = lockerRepository.getAllAvailableSlots();
    final List<Slot> filterdSlots = slotFilteringStrategy.filterSlots(allAvailableSlots, lockerItem);
    final Slot slotToBeAllocated = slotAssignmentStrategy.pickSlot(filterdSlots);

    if(slotToBeAllocated == null)
      throw new NoSlotAvailableException();
    slotToBeAllocated.allocatePackege(lockerItem);
    return slotToBeAllocated;
  }
}
