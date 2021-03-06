package com.uber.rib.root;

import com.uber.rib.root.logged_out.LoggedOutInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RootBuilder_Module_LoggedOutListenerFactory
    implements Factory<LoggedOutInteractor.Listener> {
  private final Provider<RootInteractor> rootInteractorProvider;

  public RootBuilder_Module_LoggedOutListenerFactory(
      Provider<RootInteractor> rootInteractorProvider) {
    this.rootInteractorProvider = rootInteractorProvider;
  }

  @Override
  public LoggedOutInteractor.Listener get() {
    return Preconditions.checkNotNull(
        RootBuilder.Module.loggedOutListener(rootInteractorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoggedOutInteractor.Listener> create(
      Provider<RootInteractor> rootInteractorProvider) {
    return new RootBuilder_Module_LoggedOutListenerFactory(rootInteractorProvider);
  }

  public static LoggedOutInteractor.Listener proxyLoggedOutListener(RootInteractor rootInteractor) {
    return RootBuilder.Module.loggedOutListener(rootInteractor);
  }
}
