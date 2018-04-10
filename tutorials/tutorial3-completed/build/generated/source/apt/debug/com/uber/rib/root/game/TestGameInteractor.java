package com.uber.rib.root.game;

import java.lang.Boolean;
import java.lang.Integer;

public class TestGameInteractor {
  private TestGameInteractor() {
  }

  public static GameInteractor create(final Integer firstPlayer, final Boolean playerIsRed,
      final GameInteractor.GamePresenter presenter) {
    GameInteractor interactor = new GameInteractor();
    interactor.firstPlayer = firstPlayer;
    interactor.playerIsRed = playerIsRed;
    interactor.presenter = presenter;
    return interactor;
  }
}
