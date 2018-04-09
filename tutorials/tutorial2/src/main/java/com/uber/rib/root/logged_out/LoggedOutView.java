package com.uber.rib.root.logged_out;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.uber.rib.tutorial1.R;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Top level view for {@link LoggedOutBuilder.LoggedOutScope}.
 */
public class LoggedOutView extends LinearLayout implements LoggedOutInteractor.LoggedOutPresenter {

    public LoggedOutView(Context context) {
        this(context, null);
    }

    public LoggedOutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoggedOutView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public Observable<Pair<String, String>> playGame() {
        return RxView.clicks(findViewById(R.id.play_button))
            .map(
                    new Function<Object, Pair<String, String>>() {
                        @Override
                        public Pair<String, String> apply(Object irrelevant) throws Exception {
                            return new Pair<>(
                                    "ABC", "TEST");
                        }

            });
    }
}
