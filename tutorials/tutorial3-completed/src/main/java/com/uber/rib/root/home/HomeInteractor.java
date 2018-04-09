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

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.root.home.HomeBuilder.HomeScope;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;

/**
 * Coordinates Business Logic for {@link HomeScope}.
 */
@RibInteractor
public class HomeInteractor
    extends Interactor<HomeInteractor.HomePresenter, HomeRouter> {

  @Inject Listener listener;
  @Inject
  HomePresenter presenter;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);
    presenter
        .playGame()
        .subscribe(new Consumer<Pair<Integer, String>>() {
          @Override
          public void accept(Pair<Integer, String> names) throws Exception {
            if (names.first != -1) {
              listener.play(names.first, names.second);
            }

//            if (!isEmpty(names.first) && !isEmpty(names.second)) {
//              listener.play(names.first, names.second);
//            }
          }
        });
  }

  private boolean isEmpty(@Nullable String string) {
    return string == null || string.length() == 0;
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface HomePresenter {

    Observable<Pair<Integer, String>> playGame();
  }

  public interface Listener {
    void play(Integer firstPlayer, String userColor);
  }

}