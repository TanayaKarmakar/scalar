package com.scalar.design.lld.battleship.strategy;

import com.scalar.design.lld.battleship.model.PlayerChanceTarget;
import com.scalar.design.lld.battleship.model.player.Player;
import java.io.IOException;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface IChangeGenerationStrategy {
  PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) throws IOException;
}
