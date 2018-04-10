package com.uber.rib.root.game;

import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;
import com.uber.rib.root.home.HomeInteractor;
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
    extends Interactor<GameInteractor.GamePresenter, GameRouter> {

  @Inject @Named("first_player") Integer firstPlayer;
  @Inject @Named("player_is_red") Boolean playerIsRed;

  @Inject Board board;
  @Inject GameInteractor.Listener gameListener;
  @Inject GamePresenter presenter;

  private Boolean isPlayerTurn;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    this.isPlayerTurn = this.isFirstMoveUser();

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
                      public void accept(BoardCoordinate xy) throws Exception {
                        if (isPlayerTurn) {
                          if (board.cells[xy.getX()][xy.getY()] == null) {
                            board.currentRow = xy.getX();
                            board.currentCol = xy.getY();

                            if (playerIsRed) {
                              board.cells[xy.getX()][xy.getY()] = Board.MarkerType.RED;
                              presenter.addRedPiece(xy);
                            } else {
                              board.cells[xy.getX()][xy.getY()] = Board.MarkerType.BLUE;
                              presenter.addBluePiece(xy);
                            }

                          }


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

  private Boolean isFirstMoveUser(){
    return (this.firstPlayer > 1);
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

