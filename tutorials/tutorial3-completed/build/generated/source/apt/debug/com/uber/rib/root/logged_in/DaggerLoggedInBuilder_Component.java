package com.uber.rib.root.logged_in;

import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.Interactor_MembersInjector;
import com.uber.rib.root.RootView;
import com.uber.rib.root.logged_in.off_game.OffGameInteractor;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerLoggedInBuilder_Component implements LoggedInBuilder.Component {
  private Provider<EmptyPresenter> presenterProvider;

  private Provider<LoggedInBuilder.Component> componentProvider;

  private Provider<LoggedInInteractor> interactorProvider;

  private Provider<RootView> rootViewProvider;

  private Provider<LoggedInRouter> routerProvider;

  private Provider<OffGameInteractor.Listener> listenerProvider;

  private DaggerLoggedInBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static LoggedInBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.presenterProvider = DoubleCheck.provider(LoggedInBuilder_Module_PresenterFactory.create());
    this.componentProvider = InstanceFactory.<LoggedInBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.rootViewProvider =
        new com_uber_rib_root_logged_in_LoggedInBuilder_ParentComponent_rootView(
            builder.parentComponent);
    this.routerProvider =
        DoubleCheck.provider(
            LoggedInBuilder_Module_RouterFactory.create(
                componentProvider, interactorProvider, rootViewProvider));
    this.listenerProvider =
        DoubleCheck.provider(LoggedInBuilder_Module_ListenerFactory.create(interactorProvider));
  }

  @Override
  public void inject(LoggedInInteractor arg0) {
    injectLoggedInInteractor(arg0);
  }

  @Override
  public LoggedInRouter loggedinRouter() {
    return routerProvider.get();
  }

  @Override
  public OffGameInteractor.Listener listener() {
    return listenerProvider.get();
  }

  private LoggedInInteractor injectLoggedInInteractor(LoggedInInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements LoggedInBuilder.Component.Builder {
    private LoggedInBuilder.ParentComponent parentComponent;

    private LoggedInInteractor interactor;

    @Override
    public LoggedInBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            LoggedInBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(
            LoggedInInteractor.class.getCanonicalName() + " must be set");
      }
      return new DaggerLoggedInBuilder_Component(this);
    }

    @Override
    public Builder interactor(LoggedInInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder parentComponent(LoggedInBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }

  private static class com_uber_rib_root_logged_in_LoggedInBuilder_ParentComponent_rootView
      implements Provider<RootView> {
    private final LoggedInBuilder.ParentComponent parentComponent;

    com_uber_rib_root_logged_in_LoggedInBuilder_ParentComponent_rootView(
        LoggedInBuilder.ParentComponent parentComponent) {
      this.parentComponent = parentComponent;
    }

    @Override
    public RootView get() {
      return Preconditions.checkNotNull(
          parentComponent.rootView(), "Cannot return null from a non-@Nullable component method");
    }
  }
}
