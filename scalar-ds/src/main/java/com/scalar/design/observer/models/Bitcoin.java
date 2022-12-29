package com.scalar.design.observer.models;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public class Bitcoin {
  private Double value;

  private Bitcoin() {

  }

  public BitcoinBuilder toBuilder() {
    BitcoinBuilder builder = new BitcoinBuilder().withValue(this.value);
    return builder;
  }

  public Double getValue() {
    return value;
  }

  public static class BitcoinBuilder {
    private Double value;

    public BitcoinBuilder withValue(Double value) {
      this.value = value;
      return this;
    }

    public Bitcoin build() {
      Bitcoin bitcoin = new Bitcoin();
      bitcoin.value = this.value;
      return bitcoin;
    }
  }
}
