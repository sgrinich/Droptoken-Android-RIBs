package com.uber.rib.root.game;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;
import com.uber.rib.root.home.HomeInteractor;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

  @Inject @Named("first_player") Integer firstPlayer;
  @Inject @Named("player_is_red") Boolean playerIsRed;

  @Inject Board board;
  @Inject GameInteractor.Listener gameListener;
  @Inject GamePresenter presenter;

  private static final String COMPUTER_MOVE_URL_BASE = "https://w0ayb2ph1k.execute-api.us-west-2.amazonaws.com/production";
  private Boolean isPlayerTurn;
  private ArrayList<Integer> movesArray;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    this.isPlayerTurn = this.isFirstMoveUser();
    this.movesArray = new ArrayList<Integer>();

    if (this.isPlayerTurn) {
      presenter.setPromptPlayer();
    } else {
      presenter.setWaitingForMove();
    }

    presenter
            .pieceTouched()
            .subscribe(
                    new Consumer<BoardCoordinate>() {
                      @Override
                      public void accept(BoardCoordinate coordinate) throws Exception {
                        if (isPlayerTurn) {

                          // call function below here

                          if (board.canPlace(coordinate.getCol())) {
                            playMove(coordinate.getCol());

//                            board.placePiece(xy);
//                            board.currentRow = coordinate.getRow();
//                            board.currentCol = coordinate.getCol();
//
//                            movesArray.add(coordinate.getCol());
//
//                            if (playerIsRed) {
//                              board.cells[coordinate.getRow()][coordinate.getCol()] = Board.MarkerType.RED;
//                              presenter.addRedPiece(coordinate);
//                            } else {
//                              board.cells[coordinate.getRow()][coordinate.getCol()] = Board.MarkerType.BLUE;
//                              presenter.addBluePiece(coordinate);
//                            }
                          }

//                          isPlayerTurn = false;
//                          presenter.setWaitingForMove();
//                          getComputerMove();
                        }
//                        if (board.cells[xy.getX()][xy.getY()] == null) {
//                          if (currentPlayer == MarkerType.CROSS) {
//                            board.cells[xy.getX()][xy.getY()] = MarkerType.CROSS;
//                            board.currentRow = xy.getX();
//                            board.currentCol = xy.getY();
//                            presenter.addCross(xy);
//                            currentPlayer = MarkerType.NOUGHT;
//                          } else {
//                            board.cells[xy.getX()][xy.getY()] = MarkerType.NOUGHT;
//                            board.currentRow = xy.getX();
//                            board.currentCol = xy.getY();
//                            presenter.addNought(xy);
//                            currentPlayer = MarkerType.CROSS;
//                          }
//                        }
//                        if (board.hasWon(MarkerType.CROSS)) {
//                          presenter.setPlayerWon(playerOne);
//                        } else if (board.hasWon(MarkerType.NOUGHT)) {
//                          presenter.setPlayerWon(playerTwo);
//                        } else if (board.isDraw()) {
//                          presenter.setPlayerTie();
//                        } else {
//                          updateCurrentPlayer();
//                        }
                      }
                    });

  }

  @Override
  protected void willResignActive() {
    super.willResignActive();

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  private Boolean isFirstMoveUser() {
    return (this.firstPlayer > 1);
  }

  private String getUrlWithMoves() {
    return COMPUTER_MOVE_URL_BASE.concat("?moves=").concat(movesArray.toString());
  }

  private void getComputerMove() {
    AsyncTask task = new ComputerMoveTask(this).execute(this.getUrlWithMoves());
  }

  @Override
  public void onComputerMoveCompleted(String response) {
    Integer lastComputerMove = this.getLastComputerMove(response);

    this.playMove(lastComputerMove);
  }

  private void playMove(Integer col) {
    if (board.canPlace(col)) {
      movesArray.add(col);

      if (isPlayerTurn) {
        if (playerIsRed) {
          BoardCoordinate coordinate = board.placePiece(col, Board.MarkerType.RED);
          presenter.addRedPiece(coordinate);
        } else {
          BoardCoordinate coordinate = board.placePiece(col, Board.MarkerType.BLUE);
          presenter.addBluePiece(coordinate);
        }

        isPlayerTurn = false;
        presenter.setWaitingForMove();
        getComputerMove();
      } else {
        if (playerIsRed) {
          BoardCoordinate coordinate = board.placePiece(col, Board.MarkerType.BLUE);
          presenter.addBluePiece(coordinate);
        } else {
          BoardCoordinate coordinate = board.placePiece(col, Board.MarkerType.RED);
          presenter.addRedPiece(coordinate);
        }


        isPlayerTurn = true;
        presenter.setPromptPlayer();
      }

    }
  }



  private Integer getLastComputerMove(String response) {
    String[] responseAsArray = response.replace("[","").replace("]","").split(",");
    Log.d("Response ARray: ", responseAsArray.toString());
    String lastMoveString = responseAsArray[responseAsArray.length - 1].replaceAll("\\s","");
    Integer lastMoveInteger = Integer.parseInt(lastMoveString);
    return lastMoveInteger;
  }


  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface GamePresenter {
    void setPromptPlayer();
    void setWaitingForMove();
    void addRedPiece(BoardCoordinate xy);
    void addBluePiece(BoardCoordinate xy);
    Observable<BoardCoordinate> pieceTouched();

  }


  public interface Listener {

    /**
     * Called when the game is over.
     *
     * @param winner player that won, or null if it's a tie.
     */
//    void gameWon(@Nullable String winner);
  }

}




