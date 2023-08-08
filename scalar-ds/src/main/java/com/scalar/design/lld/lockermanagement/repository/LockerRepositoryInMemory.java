package com.scalar.design.lld.lockermanagement.repository;

import com.scalar.design.lld.lockermanagement.exception.LockerAlreadyExistsException;
import com.scalar.design.lld.lockermanagement.model.Locker;
import com.scalar.design.lld.lockermanagement.model.Slot;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class LockerRepositoryInMemory implements ILockerRepository{
  private List<Locker> allLockers;

  public LockerRepositoryInMemory() {
    this.allLockers = new ArrayList<>();
  }

  @Override
  public Locker createLocker(String id) {
    if(getLocker(id) != null)
      throw new LockerAlreadyExistsException();
    final Locker locker = new Locker(id);
    allLockers.add(locker);
    return locker;
  }

  @Override
  public List<Slot> getAllAvailableSlots() {
    List<Slot> availableSlots = new ArrayList<>();
    allLockers.forEach(locker -> availableSlots.addAll(locker.getAvailableSlots()));
    return availableSlots;
  }

  public Locker getLocker(String id) {
    for(Locker locker: allLockers) {
      if(locker.getId().equals(id))
        return locker;
    }
    return null;
  }
}
