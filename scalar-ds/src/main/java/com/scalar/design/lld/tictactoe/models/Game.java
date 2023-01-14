package com.scalar.design.lld.tictactoe.models;

import com.scalar.design.lld.tictactoe.exceptions.InvalidMoveException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public class Game {
  private Board board;
  private List<Player> players = new ArrayList<>();
  private int nextPlayerIndex = 0;
  private GameStatus status;
  private Player winner;

  private Game() {

  }

  public static GameBuilder builder() {
    return new GameBuilder();
  }

  public void makeMove() {
    // get the next player
    Player player = getNextPlayer();
    Move move = player.makeMove(board);
    if(!board.isEmpty(move.getRow(), move.getCol())) {
      throw new InvalidMoveException("Cell is not empty");
    }

    //update the board
    board.getCells().get(move.getRow()).get(move.getCol()).setSymbol(player.getSymbol());

    //check the winner
    if(checkWinner(player.getSymbol())) {
      status = GameStatus.WON;
      winner = player;
      return;
    }

    if(chekDraw()) {

    }

    nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
  }

  public Player getWinner() {
    return winner;
  }

  public GameStatus getStatus() {
    return status;
  }

  private boolean chekDraw() {
    return false;
  }

  //use strategy pattern to abstract away winning strategy
  private boolean checkWinner(Symbol symbol) {
    return false;
    //return checkRows() || checkColumns() || checkDiagonals();
  }

  public Player getNextPlayer() {
    return players.get(nextPlayerIndex);
  }


  public static class GameBuilder {
    private Game game;

    public GameBuilder() {
      this.game = new Game();
      this.game.status = GameStatus.IN_PROGRESS;
    }

    public GameBuilder withDimensions(int row, int col) {
      Board board = new Board(row, col);
      game.board = board;
      return this;
    }

    public GameBuilder withPlayer(Player player) {
      game.players.add(player);
      return this;
    }

    public Game build() {
      boolean isValid = validate();
      if(!isValid)
        throw new RuntimeException("Game is not valid");
      return game;
    }

    private boolean validate() {
      if(game.players.size() < 2)
        return false;
      return true;
    }
  }
}
