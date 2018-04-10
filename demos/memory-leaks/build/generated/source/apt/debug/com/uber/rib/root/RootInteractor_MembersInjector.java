package com.uber.rib.root;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RootInteractor_MembersInjector implements MembersInjector<RootInteractor> {
  private final Provider<RootInteractor.RootPresenter> presenterProvider;

  public RootInteractor_MembersInjector(Provider<RootInteractor.RootPresenter> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<RootInteractor> create(
      Provider<RootInteractor.RootPresenter> presenterProvider) {
    return new RootInteractor_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(RootInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(RootInteractor instance, Object presenter) {
    instance.presenter = (RootInteractor.RootPresenter) presenter;
  }
}
