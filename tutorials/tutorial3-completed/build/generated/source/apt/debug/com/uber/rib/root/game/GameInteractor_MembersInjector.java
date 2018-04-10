package com.uber.rib.root.game;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameInteractor_MembersInjector implements MembersInjector<GameInteractor> {
  private final Provider<GameInteractor.GamePresenter> presenterProvider;

  private final Provider<Integer> firstPlayerProvider;

  private final Provider<Boolean> playerIsRedProvider;

  public GameInteractor_MembersInjector(
      Provider<GameInteractor.GamePresenter> presenterProvider,
      Provider<Integer> firstPlayerProvider,
      Provider<Boolean> playerIsRedProvider) {
    this.presenterProvider = presenterProvider;
    this.firstPlayerProvider = firstPlayerProvider;
    this.playerIsRedProvider = playerIsRedProvider;
  }

  public static MembersInjector<GameInteractor> create(
      Provider<GameInteractor.GamePresenter> presenterProvider,
      Provider<Integer> firstPlayerProvider,
      Provider<Boolean> playerIsRedProvider) {
    return new GameInteractor_MembersInjector(
        presenterProvider, firstPlayerProvider, playerIsRedProvider);
  }

  @Override
  public void injectMembers(GameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectFirstPlayer(instance, firstPlayerProvider.get());
    injectPlayerIsRed(instance, playerIsRedProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectFirstPlayer(GameInteractor instance, Integer firstPlayer) {
    instance.firstPlayer = firstPlayer;
  }

  public static void injectPlayerIsRed(GameInteractor instance, Boolean playerIsRed) {
    instance.playerIsRed = playerIsRed;
  }

  public static void injectPresenter(GameInteractor instance, Object presenter) {
    instance.presenter = (GameInteractor.GamePresenter) presenter;
  }
}
