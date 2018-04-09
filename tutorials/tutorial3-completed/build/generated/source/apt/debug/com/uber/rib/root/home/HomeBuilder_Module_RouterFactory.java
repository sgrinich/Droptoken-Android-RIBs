package com.uber.rib.root.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeBuilder_Module_RouterFactory implements Factory<HomeRouter> {
  private final Provider<HomeBuilder.Component> componentProvider;

  private final Provider<HomeView> viewProvider;

  private final Provider<HomeInteractor> interactorProvider;

  public HomeBuilder_Module_RouterFactory(
      Provider<HomeBuilder.Component> componentProvider,
      Provider<HomeView> viewProvider,
      Provider<HomeInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public HomeRouter get() {
    return Preconditions.checkNotNull(
        HomeBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeRouter> create(
      Provider<HomeBuilder.Component> componentProvider,
      Provider<HomeView> viewProvider,
      Provider<HomeInteractor> interactorProvider) {
    return new HomeBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static HomeRouter proxyRouter(Object component, HomeView view, HomeInteractor interactor) {
    return HomeBuilder.Module.router((HomeBuilder.Component) component, view, interactor);
  }
}
