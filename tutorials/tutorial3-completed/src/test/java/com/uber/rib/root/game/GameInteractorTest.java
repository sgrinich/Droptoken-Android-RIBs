package com.uber.rib.root.game;


import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.root.home.HomeInteractor;
import com.uber.rib.root.home.HomeRouter;
import com.uber.rib.root.home.TestHomeInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameInteractorTest extends RibTestBasePlaceholder {

    @Mock GameInteractor.Listener gameListener;
    @Mock GameInteractor.GamePresenter presenter;
    @Mock GameRouter router;

  private GameInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestGameInteractor.create(true, true, gameListener, presenter);
  }

  @Test
  public void attach_whenViewPlayGame_shouldCallListener() {
//      when(presenter.playGame()).thenReturn(Observable.just(true));
//      when(presenter.choseRedColor()).thenReturn(Observable.just(true));
//      when(presenter.choseBlueColor()).thenReturn(Observable.just(true));
//      when(presenter.chosePlayerFirst()).thenReturn(Observable.just(true));
//      when(presenter.choseComputerFirst()).thenReturn(Observable.just(true));

//      InteractorHelper.attach(interactor, presenter, router, null);

//      verify(gameListener).play(true, true);
  }

}
