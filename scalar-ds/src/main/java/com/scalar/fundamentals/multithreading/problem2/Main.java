package com.scalar.fundamentals.multithreading.problem2;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) {
    for(int i = 1; i <= 10; i++) {
      NumberPrinter np = new NumberPrinter(i);
      Thread thread = new Thread(np);
      thread.start();
    }
  }
}
