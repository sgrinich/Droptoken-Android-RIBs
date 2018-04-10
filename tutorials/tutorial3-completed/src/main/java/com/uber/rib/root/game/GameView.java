package com.uber.rib.root.game;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Top level view for {@link GameBuilder.GameScope}.
 */
class GameView extends PercentRelativeLayout implements GameInteractor.GamePresenter {

  public GameView(Context context) {
    this(context, null);
  }

  public GameView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public GameView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }
}
