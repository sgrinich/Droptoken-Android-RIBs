package com.uber.rib.root.game;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;
import com.uber.rib.root.home.HomeInteractor;

import javax.inject.Inject;

/**
 * Coordinates Business Logic for {@link GameScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class GameInteractor
    extends Interactor<GameInteractor.GamePresenter, GameRouter> {

  @Inject GamePresenter presenter;
//  @Inject Listener gameListener;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  @Override
  protected void willResignActive() {
    super.willResignActive();

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }


  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface GamePresenter { }

//  public interface Listener {
//  }

}

