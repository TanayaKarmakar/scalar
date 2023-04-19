package com.scalar.design.lld.ridesharingapp.services.strategies;

import com.scalar.design.lld.ridesharingapp.models.TripMetaData;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public interface PricingStrategy {
  double calculatePrice(TripMetaData tripMetaData);
}
