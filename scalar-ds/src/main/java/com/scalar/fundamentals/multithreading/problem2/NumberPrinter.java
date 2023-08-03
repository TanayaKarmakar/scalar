package com.scalar.fundamentals.multithreading.problem2;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class NumberPrinter implements Runnable{
  private int number;

  public NumberPrinter(int number) {
    this.number = number;
  }

  @Override
  public void run() {
    System.out.println("Number - " + number + " on Thread - " + Thread.currentThread().getName());
  }
}
