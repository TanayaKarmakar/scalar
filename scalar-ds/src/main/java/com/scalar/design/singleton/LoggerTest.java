package com.scalar.design.singleton;

/**
 * @author t0k02w6 on 20/05/23
 * @project scalar-ds
 */
public class LoggerTest {
  public static void main(String[] args) {
    Thread th1 = new Thread(new Runnable1());
    Thread th2 = new Thread(new Runnable2());

    th1.start();
    th2.start();

//    Logger logger = Logger.getInstance();
//    System.out.println("User1 has created instance");
//
//    logger = Logger.getInstance();
//    System.out.println("User2 has created instance");
  }

  static class Runnable1 implements Runnable {

    @Override
    public void run() {
      Logger logger = Logger.getInstance();
      System.out.println("User1 has created instance");
    }
  }

  static class Runnable2 implements Runnable {

    @Override
    public void run() {
      Logger logger = Logger.getInstance();
      System.out.println("User2 has created instance");
    }
  }
}
