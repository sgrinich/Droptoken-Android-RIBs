package com.uber.rib.root.logged_in.off_game;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OffGameBuilder_Module_RouterFactory implements Factory<OffGameRouter> {
  private final Provider<OffGameBuilder.Component> componentProvider;

  private final Provider<OffGameView> viewProvider;

  private final Provider<OffGameInteractor> interactorProvider;

  public OffGameBuilder_Module_RouterFactory(
      Provider<OffGameBuilder.Component> componentProvider,
      Provider<OffGameView> viewProvider,
      Provider<OffGameInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public OffGameRouter get() {
    return Preconditions.checkNotNull(
        OffGameBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OffGameRouter> create(
      Provider<OffGameBuilder.Component> componentProvider,
      Provider<OffGameView> viewProvider,
      Provider<OffGameInteractor> interactorProvider) {
    return new OffGameBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static OffGameRouter proxyRouter(
      Object component, OffGameView view, OffGameInteractor interactor) {
    return OffGameBuilder.Module.router((OffGameBuilder.Component) component, view, interactor);
  }
}
