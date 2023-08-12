package com.scalar.design.lld.battleship.strategy;

import com.scalar.design.lld.battleship.exceptions.InvalidInputException;
import com.scalar.design.lld.battleship.io.input.IInputProvider;
import com.scalar.design.lld.battleship.io.input.PlayerInput;
import com.scalar.design.lld.battleship.model.Coordinate;
import com.scalar.design.lld.battleship.model.PlayerChanceTarget;
import com.scalar.design.lld.battleship.model.player.Player;
import java.io.IOException;
import java.util.List;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class LocalChanceGeneration implements IChangeGenerationStrategy {
  private final IInputProvider inputProvider;

  public LocalChanceGeneration(IInputProvider inputProvider) {
    this.inputProvider = inputProvider;
  }

  @Override
  public PlayerChanceTarget getPlayerChanceTarget(final List<Player> opponents) throws IOException {
    final PlayerInput playerInput = inputProvider.takeInput();
    Player targetPlayer = null;
    for(Player player: opponents) {
      if(player.getId() == playerInput.getPlayerNum()) {
        targetPlayer = player;
        break;
      }
    }

    if(targetPlayer == null)
      throw new InvalidInputException();
    return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
  }
}
