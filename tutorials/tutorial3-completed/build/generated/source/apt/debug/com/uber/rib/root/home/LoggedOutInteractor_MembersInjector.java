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
    implements MembersInjector<LoggedOutInteractor> {
  private final Provider<LoggedOutInteractor.LoggedOutPresenter> presenterProvider;

  private final Provider<LoggedOutInteractor.Listener> listenerProvider;

  public LoggedOutInteractor_MembersInjector(
      Provider<LoggedOutInteractor.LoggedOutPresenter> presenterProvider,
      Provider<LoggedOutInteractor.Listener> listenerProvider) {
    this.presenterProvider = presenterProvider;
    this.listenerProvider = listenerProvider;
  }

  public static MembersInjector<LoggedOutInteractor> create(
      Provider<LoggedOutInteractor.LoggedOutPresenter> presenterProvider,
      Provider<LoggedOutInteractor.Listener> listenerProvider) {
    return new LoggedOutInteractor_MembersInjector(presenterProvider, listenerProvider);
  }

  @Override
  public void injectMembers(LoggedOutInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectListener(instance, listenerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectListener(
      LoggedOutInteractor instance, LoggedOutInteractor.Listener listener) {
    instance.listener = listener;
  }

  public static void injectPresenter(LoggedOutInteractor instance, Object presenter) {
    instance.presenter = (LoggedOutInteractor.LoggedOutPresenter) presenter;
  }
}
