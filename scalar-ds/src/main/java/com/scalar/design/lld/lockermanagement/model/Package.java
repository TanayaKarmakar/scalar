package com.scalar.design.lld.lockermanagement.model;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class Package implements LockerItem{
  private final String id;
  private final Size size;

  public Package(String id, Size size) {
    this.id = id;
    this.size = size;
  }

  @Override
  public Size getSize() {
    return null;
  }
}
