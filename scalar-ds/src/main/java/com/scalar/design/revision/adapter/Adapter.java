package com.scalar.design.revision.adapter;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class Adapter extends DataAnalyticsTool {
  private XMLData xmlData;

  public Adapter(XMLData xmlData) {
    this.xmlData = xmlData;
  }

  public void analyzeData() {
    System.out.println("Converting XML Data " + xmlData.getXmlData() + " to JSON data ");
    System.out.println("Analyzing the converted JSON data ");
  }

}
