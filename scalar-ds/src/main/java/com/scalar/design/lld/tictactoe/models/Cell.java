package com.scalar.design.lld.tictactoe.models;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public class Cell {
  private Integer row;
  private Integer col;
  private Symbol symbol;

  public Cell(Integer row, Integer col) {
    this.row = row;
    this.col = col;
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public Integer getCol() {
    return col;
  }

  public void setCol(Integer col) {
    this.col = col;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  public void setSymbol(Symbol symbol) {
    this.symbol = symbol;
  }
}
