package com.scalar.design.observer.test;

import com.scalar.design.observer.impl.BitCoinTracker;
import com.scalar.design.observer.impl.EmailService;
import com.scalar.design.observer.models.Bitcoin;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class ObserverTest {
  public static void main(String[] args) {
    Bitcoin bitcoin = new Bitcoin.BitcoinBuilder()
        .withValue(1234d).build();

    BitCoinTracker tracker = new BitCoinTracker(bitcoin);
    tracker.subscribe(new EmailService());

    tracker.setPrice(4567d);

    tracker.setPrice(8999d);
  }
}
