package com.scalar.design.factory;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class ButtonFactoryTest {
  public static void main(String[] args) {
    Button button = ButtonFactory.createButton(Platform.IOS);
    assert(button instanceof PrimaryButton);
  }
}
