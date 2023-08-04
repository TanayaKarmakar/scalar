package com.scalar.design.lld.snakeandladder;

import java.util.Objects;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class Player {
  private int id;
  private String playerName;

  public Player(int id, String playerName) {
    this.id = id;
    this.playerName = playerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return id == player.id && Objects.equals(playerName, player.playerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, playerName);
  }

  @Override
  public String toString() {
    return "Player{" +
        "id=" + id +
        ", playerName='" + playerName + '\'' +
        '}';
  }
}
