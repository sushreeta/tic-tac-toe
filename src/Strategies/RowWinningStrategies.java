package Strategies;

import Models.Board;
import Models.Move;

public class RowWinningStrategies implements CheckWinningStrategies{

    @Override
    public boolean checkWin(Board board, Move move) {
        // The row in which player made a move
        int row = move.getCell().getRow();

        //Iterate all the column indices for that row and check if all the cells occipied by the same player
        for( int i=0; i<board.getCells().size(); i++){
            if(board.getCells().get(row).get(i).getCellState() != CellState.OCCUPIED ||
                    board.getCells.get(row).get(i).getPlayer()!= move.getCell().getPlayer()){
                return false;
            }
        }
        return true;
    }
}
