package com.uber.rib.root.logged_in.tic_tac_toe;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TicTacToeBuilder_Module_RouterFactory implements Factory<TicTacToeRouter> {
  private final Provider<TicTacToeBuilder.Component> componentProvider;

  private final Provider<TicTacToeView> viewProvider;

  private final Provider<TicTacToeInteractor> interactorProvider;

  public TicTacToeBuilder_Module_RouterFactory(
      Provider<TicTacToeBuilder.Component> componentProvider,
      Provider<TicTacToeView> viewProvider,
      Provider<TicTacToeInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public TicTacToeRouter get() {
    return Preconditions.checkNotNull(
        TicTacToeBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TicTacToeRouter> create(
      Provider<TicTacToeBuilder.Component> componentProvider,
      Provider<TicTacToeView> viewProvider,
      Provider<TicTacToeInteractor> interactorProvider) {
    return new TicTacToeBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static TicTacToeRouter proxyRouter(
      Object component, TicTacToeView view, TicTacToeInteractor interactor) {
    return TicTacToeBuilder.Module.router((TicTacToeBuilder.Component) component, view, interactor);
  }
}
