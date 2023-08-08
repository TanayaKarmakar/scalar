package com.scalar.design.lld.lockermanagement.repository;

import com.scalar.design.lld.lockermanagement.model.Locker;
import com.scalar.design.lld.lockermanagement.model.Slot;
import java.util.List;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public interface ILockerRepository {
  Locker createLocker(String id);

  List<Slot> getAllAvailableSlots();
}
