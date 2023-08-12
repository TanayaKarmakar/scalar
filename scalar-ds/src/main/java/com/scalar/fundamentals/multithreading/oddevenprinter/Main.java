package com.scalar.fundamentals.multithreading.oddevenprinter;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) {
    State state = new State(PrinterType.ODD);
    Printer oddPrinter = new Printer(1, 2, 50, state, PrinterType.ODD, PrinterType.EVEN);
    Printer evenPrinter = new Printer(2, 2,50,state,PrinterType.EVEN,PrinterType.ODD);
    Thread oddThread = new Thread(oddPrinter);
    Thread evenThread = new Thread(evenPrinter);

    oddThread.start();
    evenThread.start();
  }
}
