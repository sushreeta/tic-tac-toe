package Strategies;

import Models.Board;
import Models.Move;

public interface CheckWinningStrategies {
    boolean checkWin(Board board, Move move);
}
