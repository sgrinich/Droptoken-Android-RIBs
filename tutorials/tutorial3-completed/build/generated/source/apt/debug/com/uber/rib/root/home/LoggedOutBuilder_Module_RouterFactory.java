package com.uber.rib.root.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedOutBuilder_Module_RouterFactory implements Factory<LoggedOutRouter> {
  private final Provider<LoggedOutBuilder.Component> componentProvider;

  private final Provider<LoggedOutView> viewProvider;

  private final Provider<LoggedOutInteractor> interactorProvider;

  public LoggedOutBuilder_Module_RouterFactory(
      Provider<LoggedOutBuilder.Component> componentProvider,
      Provider<LoggedOutView> viewProvider,
      Provider<LoggedOutInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.viewProvider = viewProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public LoggedOutRouter get() {
    return Preconditions.checkNotNull(
        LoggedOutBuilder.Module.router(
            componentProvider.get(), viewProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoggedOutRouter> create(
      Provider<LoggedOutBuilder.Component> componentProvider,
      Provider<LoggedOutView> viewProvider,
      Provider<LoggedOutInteractor> interactorProvider) {
    return new LoggedOutBuilder_Module_RouterFactory(
        componentProvider, viewProvider, interactorProvider);
  }

  public static LoggedOutRouter proxyRouter(
      Object component, LoggedOutView view, LoggedOutInteractor interactor) {
    return LoggedOutBuilder.Module.router((LoggedOutBuilder.Component) component, view, interactor);
  }
}
