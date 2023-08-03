package com.scalar.fundamentals.multithreading.problem4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executors = Executors.newFixedThreadPool(2);
    RandomNumberGenerator randomNumberGenerator1 = new RandomNumberGenerator();
    RandomNumberGenerator randomNumberGenerator2 = new RandomNumberGenerator();

    Future<Integer> rand1Ftr = executors.submit(randomNumberGenerator1);
    Future<Integer> rand2Ftr = executors.submit(randomNumberGenerator2);

    System.out.println("Hello World");
    System.out.println("Sum : " + (rand1Ftr.get() + rand2Ftr.get()));

    executors.shutdown();
  }
}
