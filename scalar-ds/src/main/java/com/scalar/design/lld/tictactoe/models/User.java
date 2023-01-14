package com.scalar.design.lld.tictactoe.models;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public class User {
  private String name;
  private String email;
  private Byte[] photo;

  public User(String name, String email, Byte[] photo) {
    this.name = name;
    this.email = email;
    this.photo = photo;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Byte[] getPhoto() {
    return photo;
  }
}
