package com.scalar.design.lld.battleship.io.input;

import java.io.IOException;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface IInputProvider {
  PlayerInput takeInput() throws IOException;
}
