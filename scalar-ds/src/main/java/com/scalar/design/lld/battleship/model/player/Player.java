package com.scalar.design.lld.battleship.model.player;

import com.scalar.design.lld.battleship.model.Board;
import com.scalar.design.lld.battleship.model.Coordinate;
import com.scalar.design.lld.battleship.model.PlayerChanceTarget;
import com.scalar.design.lld.battleship.strategy.IChangeGenerationStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Player {
  private final Board board;
  private final int id;
  private final IChangeGenerationStrategy changeGenerationStrategy;


  public Player(Board board, int id,
                IChangeGenerationStrategy changeGenerationStrategy) {
    this.board = board;
    this.id = id;
    this.changeGenerationStrategy = changeGenerationStrategy;
  }

  public Board getBoard() {
    return board;
  }

  public int getId() {
    return id;
  }

  public IChangeGenerationStrategy getChangeGenerationStrategy() {
    return changeGenerationStrategy;
  }

  public PlayerChanceTarget takeChance(List<Player> players) {
    List<Player> opponents = new ArrayList<>();
    for(Player player: players) {
      if(player.getId() != getId()) {
        opponents.add(player);
      }
    }
    return changeGenerationStrategy.getPlayerChanceTarget(opponents);
  }

  public void takeHit(Coordinate coordinate) {
    board.takeHit(coordinate);
  }

  public boolean areAllShipKilled() {
    return board.areAllShipsKilled();
  }
}
