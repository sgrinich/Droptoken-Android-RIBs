package com.uber.rib.root.game;

import java.lang.Boolean;

public class TestGameInteractor {
  private TestGameInteractor() {
  }

  public static GameInteractor create(final Boolean playerIsFirst, final Boolean playerIsRed,
      final Board board, final GameInteractor.Listener gameListener,
      final GameInteractor.GamePresenter presenter) {
    GameInteractor interactor = new GameInteractor();
    interactor.playerIsFirst = playerIsFirst;
    interactor.playerIsRed = playerIsRed;
    interactor.board = board;
    interactor.gameListener = gameListener;
    interactor.presenter = presenter;
    return interactor;
  }
}
