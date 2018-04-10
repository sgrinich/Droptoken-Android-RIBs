package com.uber.rib.root.game;

import android.support.annotation.NonNull;
import android.view.View;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link GameBuilder.GameScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class GameRouter extends
    ViewRouter<GameView, GameInteractor, GameBuilder.Component> {

  public GameRouter(
      GameView view,
      GameInteractor interactor,
      GameBuilder.Component component) {
    super(view, interactor, component);
  }
}
