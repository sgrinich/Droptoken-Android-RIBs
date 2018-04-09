package com.uber.rib.root.logged_in.tic_tac_toe;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TicTacToeInteractor_MembersInjector
    implements MembersInjector<TicTacToeInteractor> {
  private final Provider<TicTacToeInteractor.TicTacToePresenter> presenterProvider;

  private final Provider<Board> boardProvider;

  public TicTacToeInteractor_MembersInjector(
      Provider<TicTacToeInteractor.TicTacToePresenter> presenterProvider,
      Provider<Board> boardProvider) {
    this.presenterProvider = presenterProvider;
    this.boardProvider = boardProvider;
  }

  public static MembersInjector<TicTacToeInteractor> create(
      Provider<TicTacToeInteractor.TicTacToePresenter> presenterProvider,
      Provider<Board> boardProvider) {
    return new TicTacToeInteractor_MembersInjector(presenterProvider, boardProvider);
  }

  @Override
  public void injectMembers(TicTacToeInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectBoard(instance, boardProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectBoard(TicTacToeInteractor instance, Object board) {
    instance.board = (Board) board;
  }

  public static void injectPresenter(TicTacToeInteractor instance, Object presenter) {
    instance.presenter = (TicTacToeInteractor.TicTacToePresenter) presenter;
  }
}
