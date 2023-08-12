package com.scalar.design.lld.battleship.strategy;

import com.scalar.design.lld.battleship.model.player.Player;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface IPlayerPickingStrategy {
  int firstPlayer(List<Player> players);
  int pickNextPlayer(Integer currentPlayerIndx, List<Player> allPlayers);
}
