package com.droptoken.rib.root.game;

import com.droptoken.rib.core.Interactor_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerGameBuilder_Component implements GameBuilder.Component {
  private Provider<GameView> viewProvider;

  private Provider<GameInteractor.GamePresenter> presenterProvider;

  private Boolean firstPlayer;

  private Boolean playerIsRed;

  private GameBuilder.ParentComponent parentComponent;

  private Provider<GameBuilder.Component> componentProvider;

  private Provider<GameInteractor> interactorProvider;

  private Provider<GameRouter> routerProvider;

  private DaggerGameBuilder_Component(Builder builder) {
    initialize(builder);
  }

  public static GameBuilder.Component.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.viewProvider = InstanceFactory.create(builder.view);
    this.presenterProvider = DoubleCheck.provider((Provider) viewProvider);
    this.firstPlayer = builder.firstPlayer;
    this.playerIsRed = builder.playerIsRed;
    this.parentComponent = builder.parentComponent;
    this.componentProvider = InstanceFactory.<GameBuilder.Component>create(this);
    this.interactorProvider = InstanceFactory.create(builder.interactor);
    this.routerProvider =
        DoubleCheck.provider(
            GameBuilder_Module_RouterFactory.create(
                componentProvider, viewProvider, interactorProvider));
  }

  @Override
  public void inject(GameInteractor arg0) {
    injectGameInteractor(arg0);
  }

  @Override
  public GameRouter gameRouter() {
    return routerProvider.get();
  }

  private GameInteractor injectGameInteractor(GameInteractor instance) {
    Interactor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    GameInteractor_MembersInjector.injectPlayerIsFirst(instance, firstPlayer);
    GameInteractor_MembersInjector.injectPlayerIsRed(instance, playerIsRed);
    GameInteractor_MembersInjector.injectBoard(instance, new Board());
    GameInteractor_MembersInjector.injectGameListener(
        instance,
        Preconditions.checkNotNull(
            parentComponent.gameListener(),
            "Cannot return null from a non-@Nullable component method"));
    GameInteractor_MembersInjector.injectPresenter(instance, presenterProvider.get());
    return instance;
  }

  private static final class Builder implements GameBuilder.Component.Builder {
    private GameBuilder.ParentComponent parentComponent;

    private GameInteractor interactor;

    private GameView view;

    private Boolean firstPlayer;

    private Boolean playerIsRed;

    @Override
    public GameBuilder.Component build() {
      if (parentComponent == null) {
        throw new IllegalStateException(
            GameBuilder.ParentComponent.class.getCanonicalName() + " must be set");
      }
      if (interactor == null) {
        throw new IllegalStateException(GameInteractor.class.getCanonicalName() + " must be set");
      }
      if (view == null) {
        throw new IllegalStateException(GameView.class.getCanonicalName() + " must be set");
      }
      if (firstPlayer == null) {
        throw new IllegalStateException(Boolean.class.getCanonicalName() + " must be set");
      }
      if (playerIsRed == null) {
        throw new IllegalStateException(Boolean.class.getCanonicalName() + " must be set");
      }
      return new DaggerGameBuilder_Component(this);
    }

    @Override
    public Builder interactor(GameInteractor interactor) {
      this.interactor = Preconditions.checkNotNull(interactor);
      return this;
    }

    @Override
    public Builder view(GameView view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public Builder parentComponent(GameBuilder.ParentComponent component) {
      this.parentComponent = Preconditions.checkNotNull(component);
      return this;
    }

    @Override
    public Builder firstPlayer(Boolean firstPlayer) {
      this.firstPlayer = Preconditions.checkNotNull(firstPlayer);
      return this;
    }

    @Override
    public Builder playerIsRed(Boolean playerIsRed) {
      this.playerIsRed = Preconditions.checkNotNull(playerIsRed);
      return this;
    }
  }
}
