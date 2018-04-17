package com.uber.rib.root.home;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.support.v4.util.Pair;
import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HomeInteractorTest extends RibTestBasePlaceholder {

    @Mock HomeInteractor.HomeListener homeListener;
    @Mock HomeInteractor.HomePresenter presenter;
    @Mock HomeRouter router;

  private HomeInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestHomeInteractor.create(homeListener, presenter);
  }

  @Test
  public void attach_whenViewPlayGame_shouldCallListener() {
      when(presenter.playGame()).thenReturn(Observable.just(true));
      when(presenter.choseRedColor()).thenReturn(Observable.just(true));
      when(presenter.choseBlueColor()).thenReturn(Observable.just(true));
      when(presenter.chosePlayerFirst()).thenReturn(Observable.just(true));
      when(presenter.choseComputerFirst()).thenReturn(Observable.just(true));

      InteractorHelper.attach(interactor, presenter, router, null);

      verify(homeListener).play(true, true);
  }

}
