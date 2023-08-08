package com.scalar.design.lld.lockermanagement.strategies;

import com.scalar.design.lld.lockermanagement.model.Slot;
import java.util.List;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public interface ISlotAssignmentStrategy {
  Slot pickSlot(List<Slot> slots);
}
