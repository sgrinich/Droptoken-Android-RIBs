package com.uber.rib.root.home;

public class TestHomeInteractor {
  private TestHomeInteractor() {
  }

  public static HomeInteractor create(final HomeInteractor.HomeListener homeListener,
      final HomeInteractor.HomePresenter presenter) {
    HomeInteractor interactor = new HomeInteractor();
    interactor.homeListener = homeListener;
    interactor.presenter = presenter;
    return interactor;
  }
}
