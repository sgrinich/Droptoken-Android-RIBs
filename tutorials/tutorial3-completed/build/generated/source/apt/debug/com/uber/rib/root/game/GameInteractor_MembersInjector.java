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

  public GameInteractor_MembersInjector(Provider<GameInteractor.GamePresenter> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<GameInteractor> create(
      Provider<GameInteractor.GamePresenter> presenterProvider) {
    return new GameInteractor_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(GameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(GameInteractor instance, Object presenter) {
    instance.presenter = (GameInteractor.GamePresenter) presenter;
  }
}
