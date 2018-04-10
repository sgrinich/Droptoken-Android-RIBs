package com.uber.rib.root.game;

public class TestGameInteractor {
  private TestGameInteractor() {
  }

  public static GameInteractor create(final GameInteractor.GamePresenter presenter) {
    GameInteractor interactor = new GameInteractor();
    interactor.presenter = presenter;
    return interactor;
  }
}
