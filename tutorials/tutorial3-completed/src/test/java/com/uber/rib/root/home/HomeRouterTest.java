package com.uber.rib.root.home;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.core.RouterHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HomeRouterTest extends RibTestBasePlaceholder {

  @Mock HomeBuilder.Component component;
  @Mock HomeInteractor interactor;
  @Mock HomeView view;

  private HomeRouter router;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    router = new HomeRouter(view, interactor, component);
  }

}
