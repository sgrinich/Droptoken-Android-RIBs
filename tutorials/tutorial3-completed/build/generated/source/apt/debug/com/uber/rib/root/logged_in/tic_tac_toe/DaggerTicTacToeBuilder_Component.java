package com.uber.rib.root.logged_in.tic_tac_toe;

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
public final class DaggerTicTacToeBuilder_Component implements TicTacToeBuilder.Component {
  private Provider<TicTacToeView> viewProvider;

  private Provider<TicTacToeInteractor.TicTacToePresenter> presenterProvider;

  private Provider<TicTacToeBuilder.Component> componentProvider;

  private Provider<TicTacToeInteractor> interactorProvider;

  private Provider<TicTacToeRouter> routerProvider;

  private DaggerTicTacToeBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static TicTacToeBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.componentProvider = InstanceFactory.<TicTacToeBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.routerProvider =
        DoubleCheck.provider(
            TicTacToeBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(TicTacToeInteractor arg0) {
    injectTicTacToeInteractor(arg0);
  }

  @Override
  public TicTacToeRouter tictactoeRouter() {
    return routerProvider.get();
  }

  private TicTacToeInteractor injectTicTacToeInteractor(TicTacToeInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    TicTacToeInteractor_MembersInjector.injectBoard(instance, new Board());
    TicTacToeInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements TicTacToeBuilder.Component.Builder {
    private TicTacToeBuilder.ParentComponent parentComponent;

    private TicTacToeInteractor interactor;

    private TicTacToeView view;

    @Override
    public TicTacToeBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            TicTacToeBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(
            TicTacToeInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(TicTacToeView.class.getCanonicalName() + " must be set");
      }
      return new DaggerTicTacToeBuilder_Component(this);
    }

    @Override
    public Builder interactor(TicTacToeInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(TicTacToeView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(TicTacToeBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }
  }
}
