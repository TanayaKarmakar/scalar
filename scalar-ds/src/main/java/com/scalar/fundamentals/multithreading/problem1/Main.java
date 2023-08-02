package com.scalar.fundamentals.multithreading.problem1;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World! from thread: " + Thread.currentThread().getName());
    HelloWorldPrinter hwp = new HelloWorldPrinter();
    Thread t1 = new Thread(hwp);
    t1.start();

    Thread t2 = new Thread(hwp);
    t2.start();
  }
}
