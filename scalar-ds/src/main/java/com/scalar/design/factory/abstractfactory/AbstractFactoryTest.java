package com.scalar.design.factory.abstractfactory;

import com.scalar.design.factory.abstractfactory.impl.LightButtonFactory;
import com.scalar.design.factory.abstractfactory.impl.LightCheckboxFactory;
import com.scalar.design.factory.abstractfactory.impl.LightFormFactory;
import com.scalar.design.factory.abstractfactory.interfaces.FormFactory;
import com.scalar.design.factory.abstractfactory.interfaces.UIButtonFactory;
import com.scalar.design.factory.abstractfactory.interfaces.UICheckboxFactory;
import com.scalar.design.factory.abstractfactory.models.LightButton;
import com.scalar.design.factory.abstractfactory.models.LightCheckbox;
import com.scalar.design.factory.abstractfactory.models.UIButton;
import com.scalar.design.factory.abstractfactory.models.UICheckbox;

/**
 * @author t0k02w6 on 17/12/22
 * @project scalar-ds
 */
public class AbstractFactoryTest {
  public static void main(String[] args) {
    UIButtonFactory buttonFactory = new LightButtonFactory();
    UICheckboxFactory checkboxFactory = new LightCheckboxFactory();
    FormFactory formFactory = new LightFormFactory(buttonFactory, checkboxFactory);

    UIButton button = formFactory.createButton();

    if(button instanceof LightButton) {
      System.out.println("Light Button Created");
    } else {
      System.out.println("Dark Button Created");
    }

    UICheckbox checkbox = formFactory.createCheckbox();

    if(checkbox instanceof LightCheckbox) {
      System.out.println("Light Checkbox Created");
    } else {
      System.out.println("Dark Checkbox Created");
    }
  }
}
