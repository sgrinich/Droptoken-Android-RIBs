package com.uber.rib.root.logged_in;

import com.uber.rib.root.logged_in.off_game.OffGameInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedInBuilder_Module_ListenerFactory
    implements Factory<OffGameInteractor.Listener> {
  private final Provider<LoggedInInteractor> interactorProvider;

  public LoggedInBuilder_Module_ListenerFactory(Provider<LoggedInInteractor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public OffGameInteractor.Listener get() {
    return Preconditions.checkNotNull(
        LoggedInBuilder.Module.listener(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OffGameInteractor.Listener> create(
      Provider<LoggedInInteractor> interactorProvider) {
    return new LoggedInBuilder_Module_ListenerFactory(interactorProvider);
  }

  public static OffGameInteractor.Listener proxyListener(LoggedInInteractor interactor) {
    return LoggedInBuilder.Module.listener(interactor);
  }
}
