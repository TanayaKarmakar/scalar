package com.scalar.design.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
public class Board {
  private List<List<Cell>> cells = new ArrayList<>();

  public Board(int rowCount, int colCount) {
    IntStream.range(0, rowCount).forEach(row -> {
      List<Cell> rowCell = new ArrayList<>();
      IntStream.range(0, colCount).forEach(col -> {
        rowCell.add(new Cell(row, col));
      });
      cells.add(rowCell);
    });
  }

  public List<List<Cell>> getCells() {
    return cells;
  }

  public void setCells(List<List<Cell>> cells) {
    this.cells = cells;
  }

  public boolean isEmpty(int row, int col) {
    return cells.get(row).get(col).getSymbol() == null;
  }

  public List<Cell> getAvailableCells() {
    return cells.stream().flatMap(List::stream)
        .filter(cell -> cell.getSymbol() == null)
        .collect(Collectors.toList());
  }
}
