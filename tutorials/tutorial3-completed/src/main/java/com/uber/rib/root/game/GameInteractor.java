package com.uber.rib.root.game;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;


import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link GameScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class GameInteractor
    extends Interactor<GameInteractor.GamePresenter, GameRouter> implements OnComputerMoveCompleted {

  @Inject @Named("first_player") Boolean playerIsFirst;
  @Inject @Named("player_is_red") Boolean playerIsRed;

  @Inject Board board;
  @Inject Listener gameListener;
  @Inject GamePresenter presenter;

  private static final String COMPUTER_MOVE_URL_BASE = "https://w0ayb2ph1k.execute-api.us-west-2.amazonaws.com/production";
  private Boolean isPlayerTurn;
  private ArrayList<Integer> movesArray;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    this.initNewGame();

    presenter
            .pieceTouched()
            .subscribe(
                    new Consumer<BoardCoordinate>() {
                      @Override
                      public void accept(BoardCoordinate coordinate) throws Exception {
                        if (!board.hasWon() && isPlayerTurn && board.canPlace(coordinate.getCol())) {
                          playMove(coordinate.getCol());
                        }
                      }
                    });

  presenter
          .newGame()
            .subscribe(
              new Consumer<Boolean>() {
                @Override
                public void accept(Boolean val) throws Exception {
                  resetBoard();
                }
              }
            );

    presenter
            .goHome()
            .subscribe(
                    new Consumer<Boolean>() {
                      @Override
                      public void accept(Boolean val) throws Exception {
                        gameListener.goHome();
                      }
                    }
            );
  }

  @Override
  protected void willResignActive() {
    super.willResignActive();
  }

  @Override
  public void onComputerMoveCompleted(String response) {
    Integer lastComputerMove = this.getLastComputerMove(response);
    this.playMove(lastComputerMove);
  }

  private String getUrlWithMoves() {
    return COMPUTER_MOVE_URL_BASE.concat("?moves=").concat(movesArray.toString());
  }

  private void getComputerMove() {
    AsyncTask task = new ComputerMoveTask(this).execute(this.getUrlWithMoves());
  }

  private void initNewGame() {
    this.isPlayerTurn = this.playerIsFirst;
    this.movesArray = new ArrayList<Integer>();

    if (this.isPlayerTurn) {
      presenter.setPromptPlayer();
    } else {
      presenter.setWaitingForMove();
      this.getComputerMove();
    }
  }

  private void resetBoard() {
    this.initNewGame();
    this.board = new Board();
    presenter.removeAllPieces();
  }


  private void playMove(Integer col) {
    if (board.canPlace(col)) {
      movesArray.add(col);

      if (isPlayerTurn) {
        BoardCoordinate coordinate;
        Board.Color type;

        if (playerIsRed) {
          type = Board.Color.RED;
          coordinate = board.placePiece(col, type);
          presenter.addRedPiece(coordinate);
        } else {
          type = Board.Color.BLUE;
          coordinate = board.placePiece(col, type);
          presenter.addBluePiece(coordinate);
        }

        if (board.hasWon()) {
          presenter.setPlayerWon();
        } else if (board.isDraw()) {
          presenter.setDraw();
        } else {
          isPlayerTurn = false;
          presenter.setWaitingForMove();
          getComputerMove();
        }
      } else {
        BoardCoordinate coordinate;
        Board.Color type;

        if (playerIsRed) {
          type = type = Board.Color.BLUE;
          coordinate = board.placePiece(col, type);
          presenter.addBluePiece(coordinate);
        } else {
          type = Board.Color.RED;
          coordinate = board.placePiece(col, type);
          presenter.addRedPiece(coordinate);
        }

        if (board.hasWon()) {
          presenter.setComputerWon();
        } else if (board.isDraw()) {
          presenter.setDraw();
        } else {
          isPlayerTurn = true;
          presenter.setPromptPlayer();
        }
      }
    }
  }

  private Integer getLastComputerMove(String response) {
    String[] responseAsArray = response.replace("[","").replace("]","").split(",");
    String lastMoveString = responseAsArray[responseAsArray.length - 1].replaceAll("\\s","");
    Integer lastMoveInteger = Integer.parseInt(lastMoveString);
    return lastMoveInteger;
  }


  /**
   * Presenter interface implemented by this RIB's view.
   */
  public interface GamePresenter {
    Observable<BoardCoordinate> pieceTouched();
    Observable newGame();
    Observable goHome();

    void setPromptPlayer();
    void setWaitingForMove();
    void addRedPiece(BoardCoordinate xy);
    void addBluePiece(BoardCoordinate xy);
    void removeAllPieces();
    void setPlayerWon();
    void setComputerWon();
    void setDraw();
  }


  public interface Listener {
    void goHome();
  }

}




