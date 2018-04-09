package com.uber.rib.root.logged_out;

import com.uber.rib.core.Interactor_MembersInjector;
import com.uber.rib.root.home.LoggedOutBuilder;
import com.uber.rib.root.home.LoggedOutInteractor;
import com.uber.rib.root.home.LoggedOutRouter;
import com.uber.rib.root.home.LoggedOutView;

import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerLoggedOutBuilder_Component implements LoggedOutBuilder.Component {
  private Provider<LoggedOutView> viewProvider;

  private Provider<LoggedOutInteractor.LoggedOutPresenter> presenterProvider;

  private LoggedOutBuilder.ParentComponent parentComponent;

  private Provider<LoggedOutBuilder.Component> componentProvider;

  private Provider<LoggedOutInteractor> interactorProvider;

  private Provider<LoggedOutRouter> routerProvider;

  private DaggerLoggedOutBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static LoggedOutBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.parentComponent = builder.parentComponent;
    this.componentProvider = InstanceFactory.<LoggedOutBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.routerProvider =
        DoubleCheck.provider(
            LoggedOutBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(LoggedOutInteractor arg0) {
    injectLoggedOutInteractor(arg0);
  }

  @Override
  public LoggedOutRouter loggedoutRouter() {
    return routerProvider.get();
  }

  private LoggedOutInteractor injectLoggedOutInteractor(LoggedOutInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    LoggedOutInteractor_MembersInjector.injectListener(
        instance,
        Preconditions.checkNotNull(
            parentComponent.listener(),
            "Cannot return null from a non-@Nullable component method"));
    LoggedOutInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements LoggedOutBuilder.Component.Builder {
    private LoggedOutBuilder.ParentComponent parentComponent;

    private LoggedOutInteractor interactor;

    private LoggedOutView view;

    @Override
    public LoggedOutBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            LoggedOutBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(
            LoggedOutInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(LoggedOutView.class.getCanonicalName() + " must be set");
      }
      return new DaggerLoggedOutBuilder_Component(this);
    }

    @Override
    public Builder interactor(LoggedOutInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(LoggedOutView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(LoggedOutBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }
}
