/*
 * Copyright (C) 2017. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.rib.root.home;

import static java.lang.annotation.RetentionPolicy.CLASS;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;
import com.uber.rib.tutorial1.R;
import dagger.Binds;
import dagger.BindsInstance;
import dagger.Provides;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Builder for the {@link HomeScope}.
 */
public class HomeBuilder
        extends ViewBuilder<HomeView, HomeRouter, HomeBuilder.ParentComponent> {

  public HomeBuilder(ParentComponent dependency) {
    super(dependency);
  }

  /**
   * Builds a new {@link HomeRouter}.
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new {@link HomeRouter}.
   */
  public HomeRouter build(ViewGroup parentViewGroup) {
    HomeView view = createView(parentViewGroup);
    HomeInteractor interactor = new HomeInteractor();
    Component component = DaggerHomeBuilder_Component.builder()
            .parentComponent(getDependency())
            .view(view)
            .interactor(interactor)
            .build();
    return component.homeRouter();
  }

  @Override
  protected HomeView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
    return (HomeView) inflater.inflate(R.layout.home_rib, parentViewGroup, false);
  }

  public interface ParentComponent {
    HomeInteractor.HomeListener homeListener();
  }

  @dagger.Module
  public abstract static class Module {

    @HomeScope
    @Binds
    abstract HomeInteractor.HomePresenter presenter(HomeView view);

    @HomeScope
    @Provides
    static HomeRouter router(
            Component component,
            HomeView view,
            HomeInteractor interactor) {
      return new HomeRouter(view, interactor, component);
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @HomeScope
  @dagger.Component(modules = Module.class,
          dependencies = ParentComponent.class)
  interface Component extends InteractorBaseComponent<HomeInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {

      @BindsInstance
      Builder interactor(HomeInteractor interactor);

      @BindsInstance
      Builder view(HomeView view);

      Builder parentComponent(ParentComponent component);

      Component build();
    }
  }

  interface BuilderComponent {

    HomeRouter homeRouter();
  }

  @Scope
  @Retention(CLASS)
  @interface HomeScope {

  }

  @Qualifier
  @Retention(CLASS)
  @interface HomeInternal {

  }
}
