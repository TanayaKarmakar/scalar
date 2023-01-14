package com.scalar.design.lld.tictactoe.strategies;

import com.scalar.design.lld.tictactoe.models.Board;
import com.scalar.design.lld.tictactoe.models.Move;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public interface PlayingStrategy {
  Move makeMove(Board board);
}
