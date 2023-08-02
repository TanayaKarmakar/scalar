package com.scalar.fundamentals.multithreading.problem1;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class HelloWorldPrinter implements Runnable {
  @Override
  public void run() {
    System.out.println("Hello World from: " + Thread.currentThread().getName());
  }
}
