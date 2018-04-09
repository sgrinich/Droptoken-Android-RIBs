package com.uber.rib.root;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RootBuilder_Module_RouterFactory implements Factory<RootRouter> {
  private final Provider<RootBuilder.Component> componentProvider;

  private final Provider<RootView> viewProvider;

  private final Provider<RootInteractor> interactorProvider;

  public RootBuilder_Module_RouterFactory(
      Provider<RootBuilder.Component> componentProvider,
      Provider<RootView> viewProvider,
      Provider<RootInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public RootRouter get() {
    return Preconditions.checkNotNull(
        RootBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RootRouter> create(
      Provider<RootBuilder.Component> componentProvider,
      Provider<RootView> viewProvider,
      Provider<RootInteractor> interactorProvider) {
    return new RootBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static RootRouter proxyRouter(Object component, RootView view, RootInteractor interactor) {
    return RootBuilder.Module.router((RootBuilder.Component) component, view, interactor);
  }
}
