package com.scalar.design.lld.tictactoe.models;

import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
@SuperBuilder
public abstract class Player {
  private Symbol symbol;

  public abstract Move makeMove(Board board);

  public Symbol getSymbol() {
    return symbol;
  }
}
