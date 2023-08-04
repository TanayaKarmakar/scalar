package com.scalar.design.lld.snakeandladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 04/08/23
 * @project scalar-ds
 */
public class GameBoard {
  private Map<Integer, Integer> snakes;
  private Map<Integer, Integer> ladders;
  private Queue<Player> nextTurn;
  private Map<Player, Integer> playerPositions;
  private Dice dice;
  private int boardSize;

  public GameBoard(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders,
                   Queue<Player> players, Dice dice, int boardSize, Map<Player, Integer> playerPositions) {
    this.snakes = snakes;
    this.ladders = ladders;
    this.nextTurn = players;
    this.playerPositions = playerPositions;
    this.dice = dice;
    this.boardSize = boardSize;
  }

  public void startGame() {
    while(nextTurn.size() > 1) {
      int diceValue = dice.rollDice();
      Player player = nextTurn.poll();
      int nextPosition = playerPositions.get(player) + diceValue;

      if(nextPosition > boardSize) {
        nextTurn.add(player);
      } else if(nextPosition == boardSize) {
        System.out.println(player + " has won the game !!!!!!");
        break;
      } else {
        if(snakes.containsKey(nextPosition)) {
          System.out.println(player + " has bitten by the snake at " + nextPosition);
          nextPosition = snakes.get(nextPosition);
        }

        if(ladders.containsKey(nextPosition)) {
          System.out.println(player + " has got ladder present at " + nextPosition);
          nextPosition = ladders.get(nextPosition);
          if(nextPosition == boardSize) {
            System.out.println(player + " has won the game !!!!!!");
            break;
          }
        }
        playerPositions.put(player, nextPosition);
        System.out.println(player + " is at position " + nextPosition);
        nextTurn.add(player);
      }
    }
  }
}
