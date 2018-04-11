/*
 * Copyright (C) 2017. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.rib.root;

import android.support.annotation.Nullable;

import com.uber.rib.core.ViewRouter;
import com.uber.rib.root.game.GameBuilder;
import com.uber.rib.root.game.GameRouter;
import com.uber.rib.root.home.HomeBuilder;
import com.uber.rib.root.home.HomeRouter;

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 */
public class RootRouter extends ViewRouter<RootView, RootInteractor, RootBuilder.Component> {

  private final HomeBuilder homeBuilder;
  private final GameBuilder gameBuilder;
  @Nullable private HomeRouter homeRouter;
  @Nullable private GameRouter gameRouter;

  RootRouter(
      RootView view,
      RootInteractor interactor,
      RootBuilder.Component component,
      HomeBuilder homeBuilder,
      GameBuilder gameBuilder) {
    super(view, interactor, component);
    this.homeBuilder = homeBuilder;
    this.gameBuilder = gameBuilder;
  }

  void attachHome() {
    homeRouter = homeBuilder.build(getView());
    attachChild(homeRouter);
    getView().addView(homeRouter.getView());
  }

  void detachHome() {
    if (homeRouter != null) {
      detachChild(homeRouter);
      getView().removeView(homeRouter.getView());
      homeRouter = null;
    }
  }

  void detachGame() {
    if (gameRouter != null) {
      detachChild(gameRouter);
      getView().removeView(gameRouter.getView());
      gameRouter = null;
    }
  }

  void attachGame(Boolean firstPlayer, Boolean playerIsRed) {
    gameRouter = gameBuilder.build(getView(), firstPlayer, playerIsRed);
    attachChild(gameRouter);
    getView().addView(gameRouter.getView());
  }
}
