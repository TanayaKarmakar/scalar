package com.scalar.design.lld.battleship;

import com.scalar.design.lld.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.scalar.design.lld.battleship.io.output.IOutputPrinter;
import com.scalar.design.lld.battleship.model.PlayerChanceTarget;
import com.scalar.design.lld.battleship.model.player.Player;
import com.scalar.design.lld.battleship.strategy.IPlayerPickingStrategy;
import com.scalar.design.lld.battleship.strategy.IWinnerStrategy;
import java.io.IOException;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class GameLoop {
  private final List<Player> players;
  private final IWinnerStrategy winnerStrategy;
  private final IOutputPrinter printer;
  private final IPlayerPickingStrategy nextPlayerStrategy;


  public GameLoop(List<Player> players, IWinnerStrategy winnerStrategy,
                  IOutputPrinter printer,
                  IPlayerPickingStrategy nextPlayerStrategy) {
    this.players = players;
    this.winnerStrategy = winnerStrategy;
    this.printer = printer;
    this.nextPlayerStrategy = nextPlayerStrategy;
  }

  public void start() throws IOException {
    int currentPlayerIndex = nextPlayerStrategy.firstPlayer(this.players);
    printer.printMsg("Starting game !!!");
    while(true) {
      final Player currentPlayer = players.get(currentPlayerIndex);
      printer.printMsg("\n\nPlayer:" + currentPlayer.getId() + " Chance:");
      final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.players);

      try {
        playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
      } catch (CoordinateOutOfBoundaryException exception) {
        printer.printMsg("Hit was out of bound !!!!");
      }

      printer.printSelfBoard(currentPlayer);
      printer.printOpponentBoard(players, currentPlayer);

      final Player winner = winnerStrategy.getWinner(players);
      if (winner != null) {
        printer.printWinner(winner);
        break;
      }
      currentPlayerIndex = nextPlayerStrategy.pickNextPlayer(currentPlayerIndex, this.players);
    }
  }
}
