package com.uber.rib.root.logged_out;

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

public class HomeInteractorTest extends RibTestBasePlaceholder {

  @Mock HomeInteractor.Listener listener;
  @Mock HomeInteractor.LoggedOutPresenter presenter;
  @Mock
  HomeRouter router;

  private HomeInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestLoggedOutInteractor.create(listener, presenter);
  }


  @Test
  public void attach_whenViewEmitsName_shouldCallListener() {
    when(presenter.loginName()).thenReturn(Observable.just(Pair.create("fakename", "fakename")));

    InteractorHelper.attach(interactor, presenter, router, null);

    verify(listener).login(any(String.class), any(String.class));
  }

  @Test
  public void attach_whenViewEmitsEmptyName_shouldNotCallListener() {
    when(presenter.loginName()).thenReturn(Observable.just(Pair.create("", "")));

    InteractorHelper.attach(interactor, presenter, router, null);

    verify(listener, never()).login(any(String.class), any(String.class));
  }
}
