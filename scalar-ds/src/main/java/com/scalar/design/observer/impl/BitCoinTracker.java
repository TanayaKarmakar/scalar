package com.scalar.design.observer.impl;

import com.scalar.design.observer.interfaces.Publisher;
import com.scalar.design.observer.models.Bitcoin;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class BitCoinTracker extends Publisher {
  private Bitcoin bitcoin;

  public BitCoinTracker(Bitcoin bitcoin) {
    this.bitcoin = bitcoin;
  }

  public void setPrice(Double value) {
    this.bitcoin = this.bitcoin.toBuilder().withValue(value).build();
    publish();
  }
}
