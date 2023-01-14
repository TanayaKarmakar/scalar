package com.scalar.design.lld.tictactoe.models;

import com.scalar.design.lld.tictactoe.strategies.PlayingStrategy;
import com.scalar.design.lld.tictactoe.strategies.RandomPlayingStrategy;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
@SuperBuilder
public class Bot extends Player {
  private BotLevel level;

  @Builder.Default
  private PlayingStrategy playingStrategy = new RandomPlayingStrategy();

  @Override
  public Move makeMove(Board board) {
    return playingStrategy.makeMove(board);
  }
}
