package com.uber.rib.root.game;

import com.uber.rib.core.RibTestBasePlaceholder;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameRouterTest extends RibTestBasePlaceholder {

  @Mock GameBuilder.Component component;
  @Mock GameInteractor interactor;
  @Mock GameView view;

  private GameRouter router;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    router = new GameRouter(view, interactor, component);
  }

}
