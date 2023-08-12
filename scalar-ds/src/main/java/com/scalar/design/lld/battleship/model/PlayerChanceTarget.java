package com.scalar.design.lld.battleship.model;

import com.scalar.design.lld.battleship.model.player.Player;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class PlayerChanceTarget {
  final Player targetPlayer;
  final Coordinate target;


  public PlayerChanceTarget(Player targetPlayer, Coordinate coordinate) {
    this.targetPlayer = targetPlayer;
    this.target = coordinate;
  }

  public Player getTargetPlayer() {
    return targetPlayer;
  }

  public Coordinate getTarget() {
    return target;
  }
}
