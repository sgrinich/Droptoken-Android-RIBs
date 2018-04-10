package com.uber.rib.root.game;

import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;
import com.uber.rib.root.home.HomeInteractor;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Coordinates Business Logic for {@link GameScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class GameInteractor
    extends Interactor<GameInteractor.GamePresenter, GameRouter> {

  @Inject @Named("first_player") Integer firstPlayer;
  @Inject @Named("player_is_red") Boolean playerIsRed;


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

  private Boolean isFirstMoveUser(){
    return !(this.firstPlayer > 1);
  }


  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface GamePresenter { }

//  public interface Listener {
//  }

}

