package com.uber.rib.root.home;

import com.uber.rib.core.Interactor;
import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class HomeInteractorTest extends RibTestBasePlaceholder {

  @Mock HomeInteractor.Listener homeListener;
  @Mock HomeInteractor.HomePresenter presenter;
  @Mock HomeRouter router;

  private HomeInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    interactor = TestHomeInteractor.create(homeListener, presenter);
  }

  @Test
  public void attach_whenPlayerChoseRed_shouldReturnTrue() {
    when(presenter.choseRedColor()).thenReturn(Observable.just(Boolean.TRUE));
  }

  @Test
  public void attach_whenPlayerChoseBlue_shouldReturnTrue() {
    when(presenter.choseBlueColor()).thenReturn(Observable.just(Boolean.TRUE));
  }

  @Test
  public void attach_whenPlayerChoseFirst_shouldReturnTrue() {
    when(presenter.chosePlayerFirst()).thenReturn(Observable.just(Boolean.TRUE));
  }

  @Test
  public void attach_whenComputerChoseFirst_shouldReturnTrue() {
    when(presenter.choseComputerFirst()).thenReturn(Observable.just(Boolean.TRUE));
  }

  @Test
  public void attach_whenViewEmitssValues_shouldCallListener() {
    when(presenter.playGame()).thenReturn(Observable.just(true));

    InteractorHelper.attach(interactor, presenter, router, null);

//    InteractorHelper.attach(interactor, presenter, router, null);


//    verify(homeListener).testFunc();
//    verify(homeListener).play(true, true);
  }


//  @Test
//  public void attach_whenViewEmitsName_shouldCallListener() {
//    when(presenter.playGame()).thenReturn(Observable.just(true));
//
//
////    when(presenter.loginName()).thenReturn(Observable.just(Pair.create("fakename", "fakename")));
////
//    InteractorHelper.attach(interactor, presenter, router, null);
//////
//    verify(listener).play(true, false);
//  }
//
//  @Test
//  public void attach_whenViewEmitsEmptyName_shouldNotCallListener() {
////    when(presenter.loginName()).thenReturn(Observable.just(Pair.create("", "")));
////
////    InteractorHelper.attach(interactor, presenter, router, null);
////
////    verify(listener, never()).login(any(String.class), any(String.class));
//  }
}
