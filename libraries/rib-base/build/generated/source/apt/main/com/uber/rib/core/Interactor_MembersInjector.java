package com.uber.rib.core;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Interactor_MembersInjector<P, R extends Router>
    implements MembersInjector<Interactor<P, R>> {
  private final Provider<P> presenterProvider;

  public Interactor_MembersInjector(Provider<P> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static <P, R extends Router> MembersInjector<Interactor<P, R>> create(
      Provider<P> presenterProvider) {
    return new Interactor_MembersInjector<P, R>(presenterProvider);
  }

  @Override
  public void injectMembers(Interactor<P, R> instance) {
    injectPresenter(instance, presenterProvider.get());
  }

  public static <P, R extends Router> void injectPresenter(Interactor<P, R> instance, P presenter) {
    instance.presenter = presenter;
  }
}
