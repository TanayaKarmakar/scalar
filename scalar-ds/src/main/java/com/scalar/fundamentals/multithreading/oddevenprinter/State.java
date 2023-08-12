package com.scalar.fundamentals.multithreading.oddevenprinter;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class State {
  private PrinterType nextPrinterType;

  public State(final PrinterType nextPrinterType) {
    this.nextPrinterType = nextPrinterType;
  }

  public PrinterType getNextPrinterType() {
    return nextPrinterType;
  }

  public void setNextPrinterType(PrinterType nextPrinterType) {
    this.nextPrinterType = nextPrinterType;
  }
}
