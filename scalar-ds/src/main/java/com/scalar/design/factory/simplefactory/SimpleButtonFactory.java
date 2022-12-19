package com.scalar.design.factory.simplefactory;

import com.scalar.design.factory.models.Button;
import com.scalar.design.factory.models.Platform;
import com.scalar.design.factory.models.PrimaryButton;
import com.scalar.design.factory.models.RoundButton;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class SimpleButtonFactory {
  public static Button createButton(Platform platform, String id, double height, double width, double radius) {
    switch (platform) {
      case ANDROID:
        return new RoundButton(id, radius);
      case MAC_OS:
        return new PrimaryButton(id, height, width);
      case IOS:
        return new RoundButton(id, radius);
    }
    throw new RuntimeException("Invalid Platform");
  }
}
