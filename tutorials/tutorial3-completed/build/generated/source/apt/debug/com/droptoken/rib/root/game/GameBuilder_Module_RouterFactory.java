package com.droptoken.rib.root.game;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameBuilder_Module_RouterFactory implements Factory<GameRouter> {
  private final Provider<GameBuilder.Component> componentProvider;

  private final Provider<GameView> viewProvider;

  private final Provider<GameInteractor> interactorProvider;

  public GameBuilder_Module_RouterFactory(
      Provider<GameBuilder.Component> componentProvider,
      Provider<GameView> viewProvider,
      Provider<GameInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public GameRouter get() {
    return Preconditions.checkNotNull(
        GameBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GameRouter> create(
      Provider<GameBuilder.Component> componentProvider,
      Provider<GameView> viewProvider,
      Provider<GameInteractor> interactorProvider) {
    return new GameBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static GameRouter proxyRouter(Object component, Object view, GameInteractor interactor) {
    return GameBuilder.Module.router(
        (GameBuilder.Component) component, (GameView) view, interactor);
  }
}
