package com.scalar.design.lld.lockermanagement.strategies;

import com.scalar.design.lld.lockermanagement.model.Slot;
import java.util.List;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class SlotAssignmentStrategyRandom implements ISlotAssignmentStrategy {
  private final IRandomGenerator randomGenerator;

  public SlotAssignmentStrategyRandom(final IRandomGenerator randomGenerator) {
    this.randomGenerator = randomGenerator;
  }

  @Override
  public Slot pickSlot(List<Slot> slots) {
    if(slots.isEmpty())
      return null;
    int slotNum = randomGenerator.getRandomNumber(slots.size());
    return slots.get(slotNum);
  }
}
