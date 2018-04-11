package com.droptoken.rib.root.game;

import com.droptoken.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameInteractor_MembersInjector implements MembersInjector<GameInteractor> {
  private final Provider<GameInteractor.GamePresenter> presenterProvider;

  private final Provider<Boolean> playerIsFirstProvider;

  private final Provider<Boolean> playerIsRedProvider;

  private final Provider<Board> boardProvider;

  private final Provider<GameInteractor.Listener> gameListenerProvider;

  public GameInteractor_MembersInjector(
      Provider<GameInteractor.GamePresenter> presenterProvider,
      Provider<Boolean> playerIsFirstProvider,
      Provider<Boolean> playerIsRedProvider,
      Provider<Board> boardProvider,
      Provider<GameInteractor.Listener> gameListenerProvider) {
    this.presenterProvider = presenterProvider;
    this.playerIsFirstProvider = playerIsFirstProvider;
    this.playerIsRedProvider = playerIsRedProvider;
    this.boardProvider = boardProvider;
    this.gameListenerProvider = gameListenerProvider;
  }

  public static MembersInjector<GameInteractor> create(
      Provider<GameInteractor.GamePresenter> presenterProvider,
      Provider<Boolean> playerIsFirstProvider,
      Provider<Boolean> playerIsRedProvider,
      Provider<Board> boardProvider,
      Provider<GameInteractor.Listener> gameListenerProvider) {
    return new GameInteractor_MembersInjector(
        presenterProvider,
        playerIsFirstProvider,
        playerIsRedProvider,
        boardProvider,
        gameListenerProvider);
  }

  @Override
  public void injectMembers(GameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectPlayerIsFirst(instance, playerIsFirstProvider.get());
    injectPlayerIsRed(instance, playerIsRedProvider.get());
    injectBoard(instance, boardProvider.get());
    injectGameListener(instance, gameListenerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPlayerIsFirst(GameInteractor instance, Boolean playerIsFirst) {
    instance.playerIsFirst = playerIsFirst;
  }

  public static void injectPlayerIsRed(GameInteractor instance, Boolean playerIsRed) {
    instance.playerIsRed = playerIsRed;
  }

  public static void injectBoard(GameInteractor instance, Board board) {
    instance.board = board;
  }

  public static void injectGameListener(
      GameInteractor instance, GameInteractor.Listener gameListener) {
    instance.gameListener = gameListener;
  }

  public static void injectPresenter(GameInteractor instance, Object presenter) {
    instance.presenter = (GameInteractor.GamePresenter) presenter;
  }
}
