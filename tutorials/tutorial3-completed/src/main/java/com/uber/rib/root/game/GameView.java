package com.uber.rib.root.game;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.uber.rib.tutorial1.R;

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


  @Override
  public void setPromptPlayer() {
    this.hideProgressBar();
    this.showPlayerPrompt();
  }

  @Override
  public void setWaitingForMove() {
    this.showProgressBar();
    this.hidePlayerPrompt();
  }

  private void hideProgressBar() {
    ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_loader);
    progressBar.setVisibility(View.INVISIBLE);
  }

  private void showProgressBar() {
    ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_loader);
    progressBar.setVisibility(View.VISIBLE);
  }

  private void showPlayerPrompt() {
    TextView textView = (TextView) findViewById(R.id.prompt);
    textView.setVisibility(View.VISIBLE);
  }

  private void hidePlayerPrompt() {
    TextView textView = (TextView) findViewById(R.id.prompt);
    textView.setVisibility(View.INVISIBLE);
  }


}
