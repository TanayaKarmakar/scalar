package com.scalar.design.lld.snakeandladder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class SnakeAndLadderPlayer {
  public static void main(String[] args) {
    Dice dice = new Dice(1);
    Player p1 = new Player(1,"Alberts");
    Player p2 = new Player(2, "Pintoss");
    Queue<Player> allPlayers = new LinkedList<>();
    allPlayers.offer(p1);
    allPlayers.offer(p2);
    Map<Integer, Integer> snakes = new HashMap<>();
    snakes.put(10, 2);
    snakes.put(99, 12);

    Map<Integer, Integer> ladders = new HashMap<>();
    ladders.put(5, 25);
    ladders.put(40, 89);

    Map<Player,Integer> playersCurrentPosition = new HashMap<>();
    playersCurrentPosition.put(p1,0);
    playersCurrentPosition.put(p2,0);
    GameBoard gb=new GameBoard(snakes, ladders, allPlayers, dice, 100, playersCurrentPosition);
    gb.startGame();
  }
}
