package com.uber.rib.root.logged_in.off_game;

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
public final class DaggerOffGameBuilder_Component implements OffGameBuilder.Component {
  private Provider<OffGameView> viewProvider;

  private Provider<OffGameInteractor.OffGamePresenter> presenterProvider;

  private OffGameBuilder.ParentComponent parentComponent;

  private Provider<OffGameBuilder.Component> componentProvider;

  private Provider<OffGameInteractor> interactorProvider;

  private Provider<OffGameRouter> routerProvider;

  private DaggerOffGameBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static OffGameBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.parentComponent = builder.parentComponent;
    this.componentProvider = InstanceFactory.<OffGameBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.routerProvider =
        DoubleCheck.provider(
            OffGameBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(OffGameInteractor arg0) {
    injectOffGameInteractor(arg0);
  }

  @Override
  public OffGameRouter offgameRouter() {
    return routerProvider.get();
  }

  private OffGameInteractor injectOffGameInteractor(OffGameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    OffGameInteractor_MembersInjector.injectListener(
        instance,
        Preconditions.checkNotNull(
            parentComponent.listener(),
            "Cannot return null from a non-@Nullable component method"));
    OffGameInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements OffGameBuilder.Component.Builder {
    private OffGameBuilder.ParentComponent parentComponent;

    private OffGameInteractor interactor;

    private OffGameView view;

    @Override
    public OffGameBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            OffGameBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(
            OffGameInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(OffGameView.class.getCanonicalName() + " must be set");
      }
      return new DaggerOffGameBuilder_Component(this);
    }

    @Override
    public Builder interactor(OffGameInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(OffGameView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(OffGameBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }
}
