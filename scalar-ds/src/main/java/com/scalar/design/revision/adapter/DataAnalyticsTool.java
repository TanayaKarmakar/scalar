package com.scalar.design.revision.adapter;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class DataAnalyticsTool {
  private String jsonData;

  public DataAnalyticsTool() {

  }

  public DataAnalyticsTool(String jsonData) {
    this.jsonData = jsonData;
  }

  public void analyzeData() {
    System.out.println("Analysing Data " + jsonData);
  }
}
