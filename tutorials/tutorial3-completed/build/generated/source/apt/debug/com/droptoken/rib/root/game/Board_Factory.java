package com.droptoken.rib.root.game;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Board_Factory implements Factory<Board> {
  private static final Board_Factory INSTANCE = new Board_Factory();

  @Override
  public Board get() {
    return new Board();
  }

  public static Factory<Board> create() {
    return INSTANCE;
  }

  public static Board newBoard() {
    return new Board();
  }
}
