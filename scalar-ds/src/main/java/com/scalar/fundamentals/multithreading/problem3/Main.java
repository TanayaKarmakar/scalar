package com.scalar.fundamentals.multithreading.problem3;

import com.scalar.fundamentals.multithreading.problem2.NumberPrinter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for(int i = 1; i <= 100; i++) {
      executorService.submit(new NumberPrinter(i));
    }
    executorService.shutdown();
  }
}
