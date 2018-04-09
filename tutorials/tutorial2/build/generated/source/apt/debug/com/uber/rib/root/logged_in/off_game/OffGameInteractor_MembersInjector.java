package com.uber.rib.root.logged_in.off_game;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OffGameInteractor_MembersInjector implements MembersInjector<OffGameInteractor> {
  private final Provider<OffGameInteractor.OffGamePresenter> presenterProvider;

  private final Provider<OffGameInteractor.Listener> listenerProvider;

  public OffGameInteractor_MembersInjector(
      Provider<OffGameInteractor.OffGamePresenter> presenterProvider,
      Provider<OffGameInteractor.Listener> listenerProvider) {
    this.presenterProvider = presenterProvider;
    this.listenerProvider = listenerProvider;
  }

  public static MembersInjector<OffGameInteractor> create(
      Provider<OffGameInteractor.OffGamePresenter> presenterProvider,
      Provider<OffGameInteractor.Listener> listenerProvider) {
    return new OffGameInteractor_MembersInjector(presenterProvider, listenerProvider);
  }

  @Override
  public void injectMembers(OffGameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectListener(instance, listenerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectListener(
      OffGameInteractor instance, OffGameInteractor.Listener listener) {
    instance.listener = listener;
  }

  public static void injectPresenter(OffGameInteractor instance, Object presenter) {
    instance.presenter = (OffGameInteractor.OffGamePresenter) presenter;
  }
}
