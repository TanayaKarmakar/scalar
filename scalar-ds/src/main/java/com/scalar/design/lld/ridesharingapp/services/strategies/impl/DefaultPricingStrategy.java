package com.scalar.design.lld.ridesharingapp.services.strategies.impl;

import com.scalar.design.lld.ridesharingapp.models.TripMetaData;
import com.scalar.design.lld.ridesharingapp.services.strategies.PricingStrategy;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class DefaultPricingStrategy implements PricingStrategy {
  @Override
  public double calculatePrice(TripMetaData tripMetaData) {
    System.out.println("Based on default startegy, price is 100");
    return 100.0;
  }
}
