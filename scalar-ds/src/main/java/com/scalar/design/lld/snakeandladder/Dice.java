package com.scalar.design.lld.snakeandladder;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class Dice {
  private int numberOfDice;

  public Dice(int numberOfDice) {
    this.numberOfDice = numberOfDice;
  }

  public int rollDice() {
    return ((int)(Math.random() * numberOfDice * (6 - 1))) + 1;
  }

}
