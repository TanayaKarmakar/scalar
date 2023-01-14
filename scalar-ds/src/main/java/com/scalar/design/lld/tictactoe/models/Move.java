package com.scalar.design.lld.tictactoe.models;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public class Move {
  private int row;
  private int col;

  public Move(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }
}
