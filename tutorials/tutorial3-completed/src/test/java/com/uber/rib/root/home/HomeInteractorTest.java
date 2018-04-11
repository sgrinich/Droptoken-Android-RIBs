package com.uber.rib.root.home;

import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;
import android.support.v4.util.Pair;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.root.home.HomeInteractor;
import com.uber.rib.root.home.HomeRouter;

import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

public class HomeInteractorTest extends RibTestBasePlaceholder {

  @Mock HomeInteractor.Listener listener;
  @Mock HomeInteractor.HomePresenter presenter;
  @Mock HomeRouter router;

  private HomeInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestHomeInteractor.create(listener, presenter);
  }

// TODO: Test
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
