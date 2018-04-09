package com.uber.rib.root.logged_in.tic_tac_toe;

public class TestTicTacToeInteractor {
  private TestTicTacToeInteractor() {
  }

  public static TicTacToeInteractor create(final Board board,
      final TicTacToeInteractor.TicTacToePresenter presenter) {
    TicTacToeInteractor interactor = new TicTacToeInteractor();
    interactor.board = board;
    interactor.presenter = presenter;
    return interactor;
  }
}
