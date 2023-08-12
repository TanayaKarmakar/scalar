package com.scalar.fundamentals.multithreading.oddevenprinter;

import lombok.SneakyThrows;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Printer implements  Runnable {
  private Integer currentValue;
  private final Integer step;
  private final Integer maxValue;
  private final State state;
  private final PrinterType currentPrinterType;
  private final PrinterType nextPrinterType;

  public Printer(Integer currentValue, Integer step, Integer maxValue,
                 State state, PrinterType currentPrinterType,
                 PrinterType nextPrinterType) {
    this.currentValue = currentValue;
    this.step = step;
    this.maxValue = maxValue;
    this.state = state;
    this.currentPrinterType = currentPrinterType;
    this.nextPrinterType = nextPrinterType;
  }

  @SneakyThrows
  @Override
  public void run() {
    while(currentValue <= maxValue) {
      synchronized (state) {
        while(this.currentPrinterType != state.getNextPrinterType()) {
          state.wait();
        }
        System.out.println(this.currentPrinterType + ":" + this.currentValue);
        Thread.sleep(1000);
        currentValue += step;
        state.setNextPrinterType(this.nextPrinterType);
        state.notifyAll();
      }
    }
  }
}
