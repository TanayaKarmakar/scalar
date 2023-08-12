package com.scalar.design.lld.battleship.io.input;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class PlayerInput {
  private final Integer playerNum;
  private final Integer targetX;
  private final Integer targetY;


  public PlayerInput(Integer playerNum, Integer targetX, Integer targetY) {
    this.playerNum = playerNum;
    this.targetX = targetX;
    this.targetY = targetY;
  }

  public Integer getPlayerNum() {
    return playerNum;
  }

  public Integer getTargetX() {
    return targetX;
  }

  public Integer getTargetY() {
    return targetY;
  }
}
