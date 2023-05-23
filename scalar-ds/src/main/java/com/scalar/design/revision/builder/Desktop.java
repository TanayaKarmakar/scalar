package com.scalar.design.revision.builder;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class Desktop {
  private String monitor;
  private String keyboard;
  private String mouse;
  private String speaker;
  private String ram;
  private String processor;
  private String motherBoard;

  public void setMonitor(String monitor) {
    this.monitor = monitor;
  }

  public void setKeyboard(String keyboard) {
    this.keyboard = keyboard;
  }

  public void setMouse(String mouse) {
    this.mouse = mouse;
  }

  public void setSpeaker(String speaker) {
    this.speaker = speaker;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setMotherBoard(String motherBoard) {
    this.motherBoard = motherBoard;
  }

  public void showSpecs() {
    StringBuilder sb = new StringBuilder();
    sb.append("Monitor: ");
    sb.append(monitor);
    sb.append(", Keyboard: ");
    sb.append(keyboard);
    sb.append(", Mouse: ");
    sb.append(mouse);
    sb.append(", Speaker: ");
    sb.append(speaker);
    sb.append(", RAM: ");
    sb.append(ram);
    sb.append(", Processor: ");
    sb.append(processor);
    sb.append(", MotherBoard: ");
    sb.append(motherBoard);
    System.out.println(sb);
  }

  static class DesktopBuilder {
    private Desktop desktop;

    public DesktopBuilder() {
      desktop = new Desktop();
    }

    public DesktopBuilder withMonitor(String monitor) {
      desktop.setMonitor(monitor);
      return this;
    }

    public DesktopBuilder withKeyboard(String keyboard) {
      desktop.setKeyboard(keyboard);
      return this;
    }

    public DesktopBuilder withMouse(String mouse) {
      desktop.setMouse(mouse);
      return this;
    }

    public DesktopBuilder withSpeaker(String speaker) {
      desktop.setSpeaker(speaker);
      return this;
    }

    public DesktopBuilder withRam(String ram) {
      desktop.setRam(ram);
      return this;
    }

    public DesktopBuilder withProcessor(String processor) {
      desktop.setProcessor(processor);
      return this;
    }

    public DesktopBuilder withMotherBoard(String motherBoard) {
      desktop.setMotherBoard(motherBoard);
      return this;
    }

    public Desktop build() {
      return desktop;
    }
  }
}
