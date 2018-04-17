package com.uber.rib.root.home;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeInteractor_MembersInjector implements MembersInjector<HomeInteractor> {
  private final Provider<HomeInteractor.HomePresenter> presenterProvider;

  private final Provider<HomeInteractor.HomeListener> homeListenerProvider;

  public HomeInteractor_MembersInjector(
      Provider<HomeInteractor.HomePresenter> presenterProvider,
      Provider<HomeInteractor.HomeListener> homeListenerProvider) {
    this.presenterProvider = presenterProvider;
    this.homeListenerProvider = homeListenerProvider;
  }

  public static MembersInjector<HomeInteractor> create(
      Provider<HomeInteractor.HomePresenter> presenterProvider,
      Provider<HomeInteractor.HomeListener> homeListenerProvider) {
    return new HomeInteractor_MembersInjector(presenterProvider, homeListenerProvider);
  }

  @Override
  public void injectMembers(HomeInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    injectHomeListener(instance, homeListenerProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectHomeListener(
      HomeInteractor instance, HomeInteractor.HomeListener homeListener) {
    instance.homeListener = homeListener;
  }

  public static void injectPresenter(
      HomeInteractor instance, HomeInteractor.HomePresenter presenter) {
    instance.presenter = presenter;
  }
}
