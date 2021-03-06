package com.uber.rib.root;

import com.uber.rib.core.Interactor_MembersInjector;
import com.uber.rib.root.game.GameInteractor;
import com.uber.rib.root.home.HomeInteractor;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRootBuilder_Component implements RootBuilder.Component {
  private Provider<RootView> viewProvider;

  private Provider<RootInteractor.RootPresenter> presenterProvider;

  private Provider<RootInteractor> interactorProvider;

  private Provider<HomeInteractor.HomeListener> homeListenerProvider;

  private Provider<GameInteractor.Listener> gameListenerProvider;

  private Provider<RootBuilder.Component> componentProvider;

  private Provider<RootRouter> routerProvider;

  private DaggerRootBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static RootBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.homeListenerProvider =
        DoubleCheck.provider(RootBuilder_Module_HomeListenerFactory.create(interactorProvider));
    this.gameListenerProvider =
        DoubleCheck.provider(RootBuilder_Module_GameListenerFactory.create(interactorProvider));
    this.componentProvider = InstanceFactory.<RootBuilder.Component>create(this);
    this.routerProvider =
        DoubleCheck.provider(
            RootBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(RootInteractor arg0) {
    injectRootInteractor(arg0);
  }

  @Override
  public HomeInteractor.HomeListener homeListener() {
    return homeListenerProvider.get();
  }

  @Override
  public GameInteractor.Listener gameListener() {
    return gameListenerProvider.get();
  }

  @Override
  public RootRouter rootRouter() {
    return routerProvider.get();
  }

  private RootInteractor injectRootInteractor(RootInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    RootInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements RootBuilder.Component.Builder {
    private RootBuilder.ParentComponent parentComponent;

    private RootInteractor interactor;

    private RootView view;

    @Override
    public RootBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            RootBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(RootInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(RootView.class.getCanonicalName() + " must be set");
      }
      return new DaggerRootBuilder_Component(this);
    }

    @Override
    public Builder interactor(RootInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(RootView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(RootBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }
}
