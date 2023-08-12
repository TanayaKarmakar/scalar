package com.scalar.design.lld.battleship.strategy;

import com.scalar.design.lld.battleship.exceptions.InvalidInputException;
import com.scalar.design.lld.battleship.model.player.Player;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class RoundRobinPlayerPickingStrategy implements IPlayerPickingStrategy{
  @Override
  public int firstPlayer(List<Player> players) {
    if(players.isEmpty())
      throw new InvalidInputException();
    return 0;
  }

  @Override
  public int pickNextPlayer(Integer currentPlayerIndx, List<Player> allPlayers) {
    return (currentPlayerIndx + 1) % allPlayers.size();
  }
}
