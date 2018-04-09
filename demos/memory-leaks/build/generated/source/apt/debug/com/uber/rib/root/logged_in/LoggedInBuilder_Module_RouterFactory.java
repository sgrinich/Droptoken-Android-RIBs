package com.uber.rib.root.logged_in;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedInBuilder_Module_RouterFactory implements Factory<LoggedInRouter> {
  private final Provider<LoggedInBuilder.Component> componentProvider;

  private final Provider<LoggedInInteractor> interactorProvider;

  public LoggedInBuilder_Module_RouterFactory(
      Provider<LoggedInBuilder.Component> componentProvider,
      Provider<LoggedInInteractor> interactorProvider) {
    this.componentProvider = componentProvider;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public LoggedInRouter get() {
    return Preconditions.checkNotNull(
        LoggedInBuilder.Module.router(componentProvider.get(), interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoggedInRouter> create(
      Provider<LoggedInBuilder.Component> componentProvider,
      Provider<LoggedInInteractor> interactorProvider) {
    return new LoggedInBuilder_Module_RouterFactory(componentProvider, interactorProvider);
  }

  public static LoggedInRouter proxyRouter(
      LoggedInBuilder.Component component, LoggedInInteractor interactor) {
    return LoggedInBuilder.Module.router(component, interactor);
  }
}
