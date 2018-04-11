package com.uber.rib.root;

import com.uber.rib.root.game.GameInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RootBuilder_Module_GameListenerFactory
    implements Factory<GameInteractor.Listener> {
  private final Provider<RootInteractor> rootInteractorProvider;

  public RootBuilder_Module_GameListenerFactory(Provider<RootInteractor> rootInteractorProvider) {
    this.rootInteractorProvider = rootInteractorProvider;
  }

  @Override
  public GameInteractor.Listener get() {
    return Preconditions.checkNotNull(
        RootBuilder.Module.gameListener(rootInteractorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GameInteractor.Listener> create(
      Provider<RootInteractor> rootInteractorProvider) {
    return new RootBuilder_Module_GameListenerFactory(rootInteractorProvider);
  }

  public static GameInteractor.Listener proxyGameListener(RootInteractor rootInteractor) {
    return RootBuilder.Module.gameListener(rootInteractor);
  }
}
