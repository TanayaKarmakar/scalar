package com.scalar.design.factory.abstractfactory_1;

import com.scalar.design.factory.abstractfactory_1.interfaces.IButton;
import com.scalar.design.factory.abstractfactory_1.interfaces.IFactory;
import com.scalar.design.factory.abstractfactory_1.interfaces.ITextBox;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class FactoryTest {
  public static void main(String[] args) {
    IFactory osFactory = GUIAbstractFactory.createFactory("windows");

    IButton iButton = osFactory.createButton();
    ITextBox iTextBox = osFactory.createTextBox();

    iButton.press();
    iTextBox.showText();
  }
}
