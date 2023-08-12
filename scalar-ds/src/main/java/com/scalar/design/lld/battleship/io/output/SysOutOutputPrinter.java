package com.scalar.design.lld.battleship.io.output;

import com.scalar.design.lld.battleship.model.player.Player;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class SysOutOutputPrinter implements IOutputPrinter {
  @Override
  public void printMsg(String s) {
    System.out.println(s);
  }

  @Override
  public void printSelfBoard(Player player) {
    printMsg("Your board status: ");
    printPlayerInfo(player);
    printMsg("Board boundary: " + player.getBoard().getBoundary());
    printMsg("Ships: " + player.getBoard().getShips());
    printMsg("Hit locations: " + player.getBoard().hitLocations());
    printMsg("Missed locations: " + player.getBoard().missLocations());
  }

  @Override
  public void printOpponentBoard(List<Player> players, Player currentPlayer) {
    for (Player player : players) {
      if (player.getId() != currentPlayer.getId()) {
        printOpponentBoard(player);
      }
    }
  }

  @Override
  public void printWinner(Player player) {
    System.out.println("Game Finished!");
    System.out.println("Player: " + player.getId() + " won");
  }

  private void printOpponentBoard(Player player) {
    printMsg("\nOpponent board status: ");
    printPlayerInfo(player);
    printMsg("Board boundary: " + player.getBoard().getBoundary());
    printMsg("Hit locations: " + player.getBoard().hitLocations());
    printMsg("Missed locations: " + player.getBoard().missLocations());
  }

  private void printPlayerInfo(final Player player) {
    printMsg("Player: " + player.getId());
  }
}
