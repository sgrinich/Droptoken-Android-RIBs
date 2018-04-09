package com.uber.rib.root.logged_in;

import com.uber.rib.root.RootView;
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

  private final Provider<RootView> rootViewProvider;

  public LoggedInBuilder_Module_RouterFactory(
      Provider<LoggedInBuilder.Component> componentProvider,
      Provider<LoggedInInteractor> interactorProvider,
      Provider<RootView> rootViewProvider) {
    this.componentProvider = componentProvider;
    this.interactorProvider = interactorProvider;
    this.rootViewProvider = rootViewProvider;
  }

  @Override
  public LoggedInRouter get() {
    return Preconditions.checkNotNull(
        LoggedInBuilder.Module.router(
            componentProvider.get(), interactorProvider.get(), rootViewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoggedInRouter> create(
      Provider<LoggedInBuilder.Component> componentProvider,
      Provider<LoggedInInteractor> interactorProvider,
      Provider<RootView> rootViewProvider) {
    return new LoggedInBuilder_Module_RouterFactory(
        componentProvider, interactorProvider, rootViewProvider);
  }

  public static LoggedInRouter proxyRouter(
      LoggedInBuilder.Component component, LoggedInInteractor interactor, RootView rootView) {
    return LoggedInBuilder.Module.router(component, interactor, rootView);
  }
}
