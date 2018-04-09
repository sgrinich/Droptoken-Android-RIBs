package com.uber.rib.root.logged_out;

import com.uber.rib.root.home.HomeInteractor;

public class TestLoggedOutInteractor {
  private TestLoggedOutInteractor() {
  }

  public static HomeInteractor create(final HomeInteractor.Listener listener,
                                      final HomeInteractor.LoggedOutPresenter presenter) {
    HomeInteractor interactor = new HomeInteractor();
    interactor.listener = listener;
    interactor.presenter = presenter;
    return interactor;
  }
}
