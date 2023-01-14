package com.scalar.design.lld.tictactoe.strategies;

import com.scalar.design.lld.tictactoe.models.Board;
import com.scalar.design.lld.tictactoe.models.Cell;
import com.scalar.design.lld.tictactoe.models.Move;
import java.util.List;

/**
 * @author t0k02w6 on 14/01/23
 * @project scalar-ds
 */
public class RandomPlayingStrategy implements PlayingStrategy {
  @Override
  public Move makeMove(Board board) {
    // find the available cells
    List<Cell> availableCells = board.getAvailableCells();
    int randomIndx = (int)(Math.random() * availableCells.size());
    Cell randomCell = availableCells.get(randomIndx);

    return new Move(randomCell.getRow(), randomCell.getCol());
  }
}
