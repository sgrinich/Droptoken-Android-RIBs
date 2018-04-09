package com.uber.rib.root.logged_out;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.root.home.HomeBuilder;
import com.uber.rib.root.home.HomeInteractor;
import com.uber.rib.root.home.HomeRouter;
import com.uber.rib.root.home.HomeView;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HomeRouterTest extends RibTestBasePlaceholder {

  @Mock HomeBuilder.Component component;
  @Mock
  HomeInteractor interactor;
  @Mock
  HomeView view;

  private HomeRouter router;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    router = new HomeRouter(view, interactor, component);
  }
}
