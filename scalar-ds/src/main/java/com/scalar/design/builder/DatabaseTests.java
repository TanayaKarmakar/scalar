package com.scalar.design.builder;

/**
 * @author t0k02w6 on 13/12/22
 * @project scalar-ds
 */
public class DatabaseTests {
  public static void main(String[] args) {
    Database database = new Database.DatabaseBuilder()
        .host("192.168.1.4")
        .port(20000)
        .username("TestUser")
        .password("TestPwd")
        .type(DatabaseType.MY_SQL)
        .build();
  }
}
