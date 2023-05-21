package com.scalar.design.revision.adapter;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class AdapterTest {
  public static void main(String[] args) {
    XMLData xmlData = new XMLData("Samle XML Data");
    DataAnalyticsTool tool = new Adapter(xmlData);
    Client client = new Client();
    client.processData(tool);
  }
}
