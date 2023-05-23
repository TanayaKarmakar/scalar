package com.scalar.design.revision.builder;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class BuilderTest {
  public static void main(String[] args) {
    Desktop desktop = new Desktop.DesktopBuilder()
        .withMonitor("Monitor1")
        .withKeyboard("Keyboard1")
        .withMouse("Mouse1")
        .withMotherBoard("Motherboard1")
        .withProcessor("Processor1")
        .withRam("Ram1")
        .withSpeaker("Speaker1")
        .build();

    desktop.showSpecs();
  }
}
