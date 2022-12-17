package com.scalar.design.factory;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class ButtonFactory {
  public static Button createButton(Platform platform) {
    switch (platform) {
      case ANDROID:
        return new RoundButton();
      case MAC_OS:
        return new PrimaryButton();
      case IOS:
        return new RoundButton();
    }
    throw new RuntimeException("Invalid Platform");
  }
}
