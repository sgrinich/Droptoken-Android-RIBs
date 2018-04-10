package com.uber.rib.root.logged_in;

import com.uber.rib.core.EmptyPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoggedInBuilder_Module_PresenterFactory implements Factory<EmptyPresenter> {
  private static final LoggedInBuilder_Module_PresenterFactory INSTANCE =
      new LoggedInBuilder_Module_PresenterFactory();

  @Override
  public EmptyPresenter get() {
    return Preconditions.checkNotNull(
        LoggedInBuilder.Module.presenter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EmptyPresenter> create() {
    return INSTANCE;
  }

  public static EmptyPresenter proxyPresenter() {
    return LoggedInBuilder.Module.presenter();
  }
}
