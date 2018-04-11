package com.droptoken.rib.root.home;

public class TestHomeInteractor {
  private TestHomeInteractor() {
  }

  public static HomeInteractor create(final HomeInteractor.Listener listener,
      final HomeInteractor.HomePresenter presenter) {
    HomeInteractor interactor = new HomeInteractor();
    interactor.listener = listener;
    interactor.presenter = presenter;
    return interactor;
  }
}
