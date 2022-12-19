package com.scalar.design.factory.simplefactory;

import com.scalar.design.factory.models.Button;
import com.scalar.design.factory.models.Platform;
import com.scalar.design.factory.models.PrimaryButton;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class ButtonFactoryTest {
  public static void main(String[] args) {
    Button button = SimpleButtonFactory.createButton(Platform.IOS, "#btn", 0, 0, 4);
    assert(button instanceof PrimaryButton);
  }
}
