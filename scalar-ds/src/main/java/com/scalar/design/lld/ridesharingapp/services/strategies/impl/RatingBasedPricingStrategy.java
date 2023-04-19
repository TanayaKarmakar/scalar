package com.scalar.design.lld.ridesharingapp.services.strategies.impl;

import com.scalar.design.lld.ridesharingapp.models.TripMetaData;
import com.scalar.design.lld.ridesharingapp.services.strategies.PricingStrategy;
import com.scalar.design.lld.ridesharingapp.util.AttributesUtil;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class RatingBasedPricingStrategy implements PricingStrategy {
  @Override
  public double calculatePrice(TripMetaData tripMetaData) {
    double price = AttributesUtil.isHighRating(tripMetaData.getRiderRating()) ? 55.0: 65.0;

    return price;
  }
}
