package com.scalar.design.lld.chess;


/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public abstract class Piece {
  Position currentPosition;
  Board currentBoard;
  private Color color;

  public void move(Position destination) {
    if(isValid(destination)) {
      currentPosition = destination;
    }
    Piece destinationPiece = currentBoard.get(destination);
    if(destinationPiece != null && destinationPiece.getColor() != color) {
      // is a capture

    }
  }

  public boolean isValid(Position end) {
    Board temp = new Board();
    temp.makeMove(this, end);
    if(currentKingInCheck(temp, color))
      return false;
    else {
      Piece destinationPiece = currentBoard.get(end);
      if(destinationPiece != null && destinationPiece.getColor() == color) {
        return false;
      }
      return isValidMove();
    }
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }



  protected abstract boolean isValidMove();

  protected boolean currentKingInCheck(Board board, Color color) {
    return false;
  }

  abstract void getAllPossibleMoves();
}
