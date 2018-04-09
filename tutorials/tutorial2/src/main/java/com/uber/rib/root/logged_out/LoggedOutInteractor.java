package com.uber.rib.root.logged_out;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.root.logged_out.LoggedOutBuilder.LoggedOutScope;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link LoggedOutScope}.
 */
@RibInteractor
public class LoggedOutInteractor
        extends Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter> {

    @Inject Listener listener;
    @Inject LoggedOutPresenter presenter;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        presenter
            .playGame()
                .subscribe(new Consumer<Pair<String, String>>() {
                @Override
                public void accept(Pair<String, String> names) throws Exception {
                    listener.requestPlayGame(names.first, names.second);
                }
            });
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface LoggedOutPresenter {
        Observable<Pair<String, String>> playGame();
    }

    public interface Listener {
        void requestPlayGame(String firstPlayer, String userColor);
    }
}
