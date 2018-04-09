package com.uber.rib.root.logged_in;

import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.Interactor_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedInInteractor_MembersInjector
    implements MembersInjector<LoggedInInteractor> {
  private final Provider<EmptyPresenter> presenterProvider;

  public LoggedInInteractor_MembersInjector(Provider<EmptyPresenter> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<LoggedInInteractor> create(
      Provider<EmptyPresenter> presenterProvider) {
    return new LoggedInInteractor_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(LoggedInInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
  }
}
