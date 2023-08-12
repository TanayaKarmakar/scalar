package com.scalar.design.lld.battleship.strategy;

import com.scalar.design.lld.battleship.model.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class DefaultWinnerStrategy implements IWinnerStrategy {
  @Override
  public Player getWinner(List<Player> players) {
    final List<Player> alivePlayers = new ArrayList<>();
    for(Player player: players) {
      if(!player.areAllShipKilled()) {
        alivePlayers.add(player);
      }
    }
    if(alivePlayers.size() == 1)
      return alivePlayers.get(0);
    return null;
  }
}
