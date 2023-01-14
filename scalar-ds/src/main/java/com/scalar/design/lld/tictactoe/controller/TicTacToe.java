package com.scalar.design.lld.tictactoe.controller;

import com.scalar.design.lld.tictactoe.models.Bot;
import com.scalar.design.lld.tictactoe.models.BotLevel;
import com.scalar.design.lld.tictactoe.models.Game;
import com.scalar.design.lld.tictactoe.models.GameStatus;
import com.scalar.design.lld.tictactoe.models.HumanPlayer;
import com.scalar.design.lld.tictactoe.models.Player;
import com.scalar.design.lld.tictactoe.models.Symbol;
import com.scalar.design.lld.tictactoe.models.User;

/**
 * @author t0k02w6 on 14/01/23
 * @project scalar-ds
 */
public class TicTacToe {
  public static void main(String[] args) {
    Game game = createGame();

    System.out.println("Welcome to Morphy's Tictactoe");

    while(game.getStatus() == GameStatus.IN_PROGRESS) {
      Player nextPlayer = game.getNextPlayer();
      System.out.println("Next move is of Player : " + nextPlayer.getSymbol());
      game.makeMove();
    }

    if(game.getStatus().equals(GameStatus.DRAWN)) {
      System.out.println("Game Drawn: No Winner");
    }

    if(game.getStatus().equals(GameStatus.WON)) {
      System.out.println("Game won: Winner " + game.getWinner());
    }
  }

  private static Game createGame() {
    Player human = HumanPlayer.builder()
        .symbol(Symbol.O)
        .user(new User("Paul Murphy", "paul@chess.com", null))
        .build();

    Player bot = Bot.builder()
        .symbol(Symbol.X)
        .level(BotLevel.EASY)
        .build();

    return Game.builder()
        .withDimensions(3,3)
        .withPlayer(human)
        .withPlayer(bot)
        .build();
  }

}
