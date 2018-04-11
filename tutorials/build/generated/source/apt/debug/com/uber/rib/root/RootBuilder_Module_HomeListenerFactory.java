package com.uber.rib.root;

import com.uber.rib.root.home.HomeInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RootBuilder_Module_HomeListenerFactory
    implements Factory<HomeInteractor.Listener> {
  private final Provider<RootInteractor> rootInteractorProvider;

  public RootBuilder_Module_HomeListenerFactory(Provider<RootInteractor> rootInteractorProvider) {
    this.rootInteractorProvider = rootInteractorProvider;
  }

  @Override
  public HomeInteractor.Listener get() {
    return Preconditions.checkNotNull(
        RootBuilder.Module.homeListener(rootInteractorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeInteractor.Listener> create(
      Provider<RootInteractor> rootInteractorProvider) {
    return new RootBuilder_Module_HomeListenerFactory(rootInteractorProvider);
  }

  public static HomeInteractor.Listener proxyHomeListener(RootInteractor rootInteractor) {
    return RootBuilder.Module.homeListener(rootInteractor);
  }
}
