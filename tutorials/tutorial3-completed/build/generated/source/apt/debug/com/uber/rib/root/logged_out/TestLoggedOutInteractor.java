package com.uber.rib.root.logged_out;

import com.uber.rib.root.home.LoggedOutInteractor;

public class TestLoggedOutInteractor {
  private TestLoggedOutInteractor() {
  }

  public static LoggedOutInteractor create(final LoggedOutInteractor.Listener listener,
                                           final LoggedOutInteractor.LoggedOutPresenter presenter) {
    LoggedOutInteractor interactor = new LoggedOutInteractor();
    interactor.listener = listener;
    interactor.presenter = presenter;
    return interactor;
  }
}
