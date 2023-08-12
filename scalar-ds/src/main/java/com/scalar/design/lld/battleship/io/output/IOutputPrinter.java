package com.scalar.design.lld.battleship.io.output;

import com.scalar.design.lld.battleship.model.player.Player;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface IOutputPrinter {
  void printMsg(String s);

  void printSelfBoard(Player currentPlayer);

  void printOpponentBoard(List<Player> players, Player currentPlayer);

  void printWinner(Player winner);
}
