package com.uber.rib.root.home;

import com.uber.rib.core.Interactor_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerHomeBuilder_Component implements HomeBuilder.Component {
  private Provider<HomeView> viewProvider;

  private Provider<HomeInteractor.HomePresenter> presenterProvider;

  private HomeBuilder.ParentComponent parentComponent;

  private Provider<HomeBuilder.Component> componentProvider;

  private Provider<HomeInteractor> interactorProvider;

  private Provider<HomeRouter> routerProvider;

  private DaggerHomeBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static HomeBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.parentComponent = builder.parentComponent;
    this.componentProvider = InstanceFactory.<HomeBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.routerProvider =
        DoubleCheck.provider(
            HomeBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(HomeInteractor arg0) {
    injectHomeInteractor(arg0);
  }

  @Override
  public HomeRouter homeRouter() {
    return routerProvider.get();
  }

  private HomeInteractor injectHomeInteractor(HomeInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    HomeInteractor_MembersInjector.injectHomeListener(
        instance,
        Preconditions.checkNotNull(
            parentComponent.homeListener(),
            "Cannot return null from a non-@Nullable component method"));
    HomeInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements HomeBuilder.Component.Builder {
    private HomeBuilder.ParentComponent parentComponent;

    private HomeInteractor interactor;

    private HomeView view;

    @Override
    public HomeBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            HomeBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(HomeInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(HomeView.class.getCanonicalName() + " must be set");
      }
      return new DaggerHomeBuilder_Component(this);
    }

    @Override
    public Builder interactor(HomeInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(HomeView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(HomeBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }
}
