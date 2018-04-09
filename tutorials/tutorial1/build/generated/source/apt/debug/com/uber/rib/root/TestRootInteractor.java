package com.uber.rib.root;

public class TestRootInteractor {
  private TestRootInteractor() {
  }

  public static RootInteractor create(final RootInteractor.RootPresenter presenter) {
    RootInteractor interactor = new RootInteractor();
    interactor.presenter = presenter;
    return interactor;
  }
}
