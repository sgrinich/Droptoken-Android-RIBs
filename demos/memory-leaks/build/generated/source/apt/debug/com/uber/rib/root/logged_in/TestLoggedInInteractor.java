package com.uber.rib.root.logged_in;

public class TestLoggedInInteractor {
  private TestLoggedInInteractor() {
  }

  public static LoggedInInteractor create() {
    LoggedInInteractor interactor = new LoggedInInteractor();
    return interactor;
  }
}
