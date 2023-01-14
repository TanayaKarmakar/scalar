package com.scalar.design.lld.tictactoe.models;

import java.util.Scanner;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 13/01/23
 * @project scalar-ds
 */
@SuperBuilder
public class HumanPlayer extends Player {
  private User user;

  @Builder.Default
  private Scanner scanner = new Scanner(System.in);

  @Override
  public Move makeMove(Board board) {
    System.out.println("Enter the row and the column");

    int row = scanner.nextInt();
    int col = scanner.nextInt();

    return new Move(row, col);
  }
}
