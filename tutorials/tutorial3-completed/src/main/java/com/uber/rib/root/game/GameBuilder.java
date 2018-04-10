package com.uber.rib.root.game;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;
import com.uber.rib.root.home.HomeInteractor;
import com.uber.rib.root.home.HomeView;
import com.uber.rib.tutorial1.R;

import java.lang.annotation.Retention;

import javax.inject.Named;
import javax.inject.Scope;
import javax.inject.Qualifier;

import dagger.Provides;
import dagger.Binds;
import dagger.BindsInstance;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Builder for the {@link GameScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class GameBuilder
    extends ViewBuilder<GameView, GameRouter, GameBuilder.ParentComponent> {

  public GameBuilder(ParentComponent dependency) {
    super(dependency);
  }

  /**
   * Builds a new {@link GameRouter}.
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new {@link GameRouter}.
   */
  public GameRouter build(ViewGroup parentViewGroup, Integer firstPlayer, Boolean playerIsRed) {
    GameView view = createView(parentViewGroup);
    GameInteractor interactor = new GameInteractor();
    Component component = DaggerGameBuilder_Component.builder()
        .parentComponent(getDependency())
        .view(view)
        .firstPlayer(firstPlayer)
        .playerIsRed(playerIsRed)
        .interactor(interactor)
        .build();
    return component.gameRouter();
  }

  @Override
  protected GameView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
    return (GameView) inflater.inflate(R.layout.game_rib, parentViewGroup, false);
  }

  public interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
//    GameInteractor.Listener gameListener();
  }

  @dagger.Module
  public abstract static class Module {

    @GameScope
    @Binds
    abstract GameInteractor.GamePresenter presenter(GameView view);

    @GameScope
    @Provides
    static GameRouter router(
      Component component,
      GameView view,
      GameInteractor interactor) {
      return new GameRouter(view, interactor, component);
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @GameScope
  @dagger.Component(modules = Module.class,
       dependencies = ParentComponent.class)
  interface Component extends InteractorBaseComponent<GameInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      Builder interactor(GameInteractor interactor);
      @BindsInstance
      Builder view(GameView view);
      Builder parentComponent(ParentComponent component);
      Component build();

      @BindsInstance
      Builder firstPlayer(@Named("first_player") Integer firstPlayer);

      @BindsInstance
      Builder playerIsRed(@Named("player_is_red") Boolean playerIsRed);
    }
  }

  interface BuilderComponent  {
    GameRouter gameRouter();
  }

  @Scope
  @Retention(CLASS)
  @interface GameScope { }

  @Qualifier
  @Retention(CLASS)
  @interface GameInternal { }
}
