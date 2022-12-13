package com.scalar.design.builder;

/**
 * @author t0k02w6 on 13/12/22
 * @project scalar-ds
 */
public class Database {
  private String host;
  private Integer port;
  private String username;
  private String password;
  private DatabaseType type;

  private Database() {

  }

  public static class DatabaseBuilder {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private DatabaseType type;

    public DatabaseBuilder() {

    }

    public DatabaseBuilder host(String host) {
      this.host = host;
      return this;
    }

    public DatabaseBuilder port(Integer port) {
      this.port = port;
      return this;
    }

    public DatabaseBuilder username(String username) {
      this.username = username;
      return this;
    }

    public DatabaseBuilder password(String password) {
      this.password = password;
      return this;
    }

    public DatabaseBuilder type(DatabaseType type) {
      this.type = type;
      return this;
    }

    public Database build() {
      Database database = new Database();
      database.host = this.host;
      database.port = this.port;
      database.username = this.username;
      database.password = this.password;
      database.type = this.type;
      return database;
    }
  }
}
