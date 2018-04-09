package com.uber.rib.root.home;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedOutInteractor_MembersInjector
    implements MembersInjector<HomeInteractor> {
  private final Provider<HomeInteractor.HomePresenter> presenterProvider;

  private final Provider<HomeInteractor.Listener> listenerProvider;

  public LoggedOutInteractor_MembersInjector(
      Provider<HomeInteractor.HomePresenter> presenterProvider,
      Provider<HomeInteractor.Listener> listenerProvider) {
    this.presenterProvider = presenterProvider;
    this.listenerProvider = listenerProvider;
  }

  public static MembersInjector<HomeInteractor> create(
      Provider<HomeInteractor.HomePresenter> presenterProvider,
      Provider<HomeInteractor.Listener> listenerProvider) {
    return new LoggedOutInteractor_MembersInjector(presenterProvider, listenerProvider);
  }

  @Override
  public void injectMembers(HomeInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectListener(instance, listenerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectListener(
          HomeInteractor instance, HomeInteractor.Listener listener) {
    instance.listener = listener;
  }

  public static void injectPresenter(HomeInteractor instance, Object presenter) {
    instance.presenter = (HomeInteractor.HomePresenter) presenter;
  }
}
