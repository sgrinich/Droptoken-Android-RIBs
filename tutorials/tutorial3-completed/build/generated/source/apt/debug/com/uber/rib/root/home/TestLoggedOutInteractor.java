package com.uber.rib.root.home;

public class TestLoggedOutInteractor {
  private TestLoggedOutInteractor() {
  }

  public static HomeInteractor create(final HomeInteractor.Listener listener,
                                      final HomeInteractor.HomePresenter presenter) {
    HomeInteractor interactor = new HomeInteractor();
    interactor.listener = listener;
    interactor.presenter = presenter;
    return interactor;
  }
}
