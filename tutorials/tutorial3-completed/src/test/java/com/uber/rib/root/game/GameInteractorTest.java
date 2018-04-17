package com.uber.rib.root.game;


import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameInteractorTest extends RibTestBasePlaceholder {

    @Mock Board board;
    @Mock GameInteractor.Listener gameListener;
    @Mock GameInteractor.GamePresenter presenter;
    @Mock GameRouter router;

  private GameInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestGameInteractor.create(true, true, board, gameListener, presenter);
  }

  @Test
  public void attach_whenViewGoHome_shouldCallListener() {
      when(presenter.pieceTouched()).thenReturn(Observable.just(new BoardCoordinate(0, 0)));
      when(presenter.newGame()).thenReturn(Observable.just(true));
      when(presenter.goHome()).thenReturn(Observable.just(true));

      InteractorHelper.attach(interactor, presenter, router, null);

      verify(gameListener).goHome();

  }

    @Test
    public void attach_whenNewGame_shouldCallPresenter() {
        when(presenter.goHome()).thenReturn(Observable.just(true));
        when(presenter.pieceTouched()).thenReturn(Observable.just(new BoardCoordinate(0, 0)));
        when(presenter.newGame()).thenReturn(Observable.just(true));

        InteractorHelper.attach(interactor, presenter, router, null);

        verify(presenter).removeAllPieces();
    }
    
}
