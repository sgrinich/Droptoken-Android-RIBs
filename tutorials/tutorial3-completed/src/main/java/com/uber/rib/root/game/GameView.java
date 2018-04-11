package com.uber.rib.root.game;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.uber.rib.core.Initializer;
import com.uber.rib.tutorial1.R;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

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

  private TextView[][] imageButtons;
  private TextView titleView;

  @Override
  public void setPromptPlayer() {
    this.hideProgressBar();
    this.showTextWithMessage("Your move");
  }

  @Override
  public void setWaitingForMove() {
    this.showProgressBar();
    this.hidePlayerPrompt();
  }

  @Initializer
  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    imageButtons = new TextView[4][];
    imageButtons[0] =
            new TextView[]{
                    (TextView) findViewById(R.id.button11),
                    (TextView) findViewById(R.id.button12),
                    (TextView) findViewById(R.id.button13),
                    (TextView) findViewById(R.id.button14)
            };
    imageButtons[1] =
            new TextView[]{
                    (TextView) findViewById(R.id.button21),
                    (TextView) findViewById(R.id.button22),
                    (TextView) findViewById(R.id.button23),
                    (TextView) findViewById(R.id.button24)
            };
    imageButtons[2] =
            new TextView[]{
                    (TextView) findViewById(R.id.button31),
                    (TextView) findViewById(R.id.button32),
                    (TextView) findViewById(R.id.button33),
                    (TextView) findViewById(R.id.button34)
            };
    imageButtons[3] =
            new TextView[]{
                    (TextView) findViewById(R.id.button41),
                    (TextView) findViewById(R.id.button42),
                    (TextView) findViewById(R.id.button43),
                    (TextView) findViewById(R.id.button44)
            };
    titleView = (TextView) findViewById(R.id.title);
  }

  @Override
  public Observable<BoardCoordinate> pieceTouched() {
    ArrayList<Observable<BoardCoordinate>> observables = new ArrayList<>();
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        final int finalRow = row;
        final int finalCol = col;
        observables.add(
                RxView.clicks(imageButtons[row][col])
                        .map(
                          new Function<Object, BoardCoordinate>() {
                            @Override
                            public BoardCoordinate apply(Object irrelevant) throws Exception {
                              return new BoardCoordinate(finalRow, finalCol);
                            }
                          }));
      }
    }
    return Observable.merge(observables);
  }

  @Override
  public Observable newGame() {
    return RxView.clicks(findViewById(R.id.new_game))
            .map(new Function<Object, Boolean>() {
              @Override
              public Boolean apply(Object o) throws Exception {
                return true;
              }
            });
  }

  @Override
  public void addRedPiece(BoardCoordinate coordinate) {
    TextView textView = imageButtons[coordinate.getRow()][coordinate.getCol()];
    textView.setBackground(getResources().getDrawable(R.drawable.red_piece));
  }

  @Override
  public void addBluePiece(BoardCoordinate coordinate) {
    TextView textView = imageButtons[coordinate.getRow()][coordinate.getCol()];
    textView.setBackground(getResources().getDrawable(R.drawable.blue_piece));
  }

  @Override
  public void setPlayerWon() {
    this.showTextWithMessage("You won");
  }

  @Override
  public void setComputerWon() {
    this.showTextWithMessage("You lost");
  }

  @Override
  public void setDraw() {
    this.showTextWithMessage("Draw");
  }

  @Override
  public void removeAllPieces() {
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        final int finalRow = row;
        final int finalCol = col;

        TextView textView = imageButtons[row][col];
        textView.setBackground(getResources().getDrawable(R.drawable.empty_piece));
      }
    }
  }

  private void hideProgressBar() {
    ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_loader);
    progressBar.setVisibility(View.INVISIBLE);
  }

  private void showProgressBar() {
    ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_loader);
    progressBar.setVisibility(View.VISIBLE);
  }

  private void showTextWithMessage(String message) {
    this.hideProgressBar();
    TextView textView = (TextView) findViewById(R.id.prompt);
    textView.setText(message);
    textView.setVisibility(View.VISIBLE);
  }

  private void hidePlayerPrompt() {
    TextView textView = (TextView) findViewById(R.id.prompt);
    textView.setVisibility(View.INVISIBLE);
  }


}
