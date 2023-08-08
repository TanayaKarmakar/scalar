package com.scalar.design.lld.lockermanagement.strategies;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class RandomGeneratorDefault implements IRandomGenerator{
  @Override
  public Integer getRandomNumber(Integer lessThanThis) {
    return (int) (Math.random() * lessThanThis);
  }
}
