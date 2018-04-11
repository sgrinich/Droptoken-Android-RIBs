package com.uber.rib.root.game;

import com.uber.rib.core.InteractorHelper;
import com.uber.rib.core.RibTestBasePlaceholder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameInteractorTest extends RibTestBasePlaceholder {

  @Mock GameInteractor.Listener listener;
  @Mock GameInteractor.GamePresenter presenter;
  @Mock GameRouter router;

  private GameInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestGameInteractor.create(true, true, new Board(), listener, presenter);
  }

//  TODO: Test
//  @Test
//  public void anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
//    InteractorHelper.attach(interactor, presenter, router, null);
//    InteractorHelper.detach(interactor);
//
//    throw new RuntimeException("Remove this test and add real tests.");
//  }

}
