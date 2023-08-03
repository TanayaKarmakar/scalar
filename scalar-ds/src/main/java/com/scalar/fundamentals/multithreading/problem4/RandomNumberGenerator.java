package com.scalar.fundamentals.multithreading.problem4;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author t0k02w6 on 02/08/23
 * @project scalar-ds
 */
public class RandomNumberGenerator implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    try {
      Thread.sleep(3000);
    }catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    }
    Random random = new Random();
    return random.nextInt();
  }
}
