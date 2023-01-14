package com.scalar.design.lld.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class Board {
  Map<Position, Piece> pieces = new HashMap<>();

  public void makeMove(Piece piece, Position destination) {
    pieces.remove(piece.currentPosition);
    pieces.put(destination, piece);
  }

  public Piece get(Position destination) {
    return pieces.get(destination);
  }
}
