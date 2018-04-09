package com.uber.rib.root.logged_in.off_game;

public class TestOffGameInteractor {
  private TestOffGameInteractor() {
  }

  public static OffGameInteractor create(final OffGameInteractor.Listener listener,
      final OffGameInteractor.OffGamePresenter presenter) {
    OffGameInteractor interactor = new OffGameInteractor();
    interactor.listener = listener;
    interactor.presenter = presenter;
    return interactor;
  }
}
