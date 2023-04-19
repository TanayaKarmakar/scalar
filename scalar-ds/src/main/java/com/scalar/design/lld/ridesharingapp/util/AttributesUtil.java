package com.scalar.design.lld.ridesharingapp.util;

import com.scalar.design.lld.ridesharingapp.enums.Rating;

/**
 * @author t0k02w6 on 19/04/23
 * @project scalar-ds
 */
public class AttributesUtil {
  public static boolean isHighRating(Rating rating) {
    return rating == Rating.FOUR || rating == Rating.FIVE;
  }
}
