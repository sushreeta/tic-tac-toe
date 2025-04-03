package Strategies;

import Models.Board;
import Models.Move;

public class ColWinningStrategies implements CheckWinningStrategies{

    @Override
    public boolean checkWin(Board board, Move move) {
        // The row in which player made a move
        int col = move.getCell().getCol();
        Player player = move.getCell().getPlayer();

        //Iterate all the row indices for that row and check if all the cells occipied by the same player
        for( int i=0; i<board.getCells().size(); i++){
            Cell cell = board.getCells()get(i).get(col);
            if(cell.getCellState().equals(CellState.FREE) || !cell.getPlayer().equals(player)){
                return false;
            }
        return true;
    }
}
