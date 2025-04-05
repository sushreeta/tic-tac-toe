import Models.Board;
import Models.Move;

public class BoardController {

    public void applyMove(Move move, Board board){
        //1. update the cell if a valid move
        //2. check winner and change state if needed.

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(!(row>=0 && col>=0 && row<board.getcells().size() && col<board.getCells().size())){
            throw new IllegalArguementException("Cell already occupied.");
        }

        if(!board.getCells().get(row).get(col).getCellState().equals(CellState.FREE)){
            throw new IllegalArguementException("Cell already occupied.");
        }

        Player player = proposedMove.getCell().getPlayer();
        //Change the board state.
        Cell cell = board.getCells().get(row).get(col);
        cell.setCellState(CellState.OCCUPIED);
        cell.setplayer(player);

        int countRows = board.getRowsMapping().get(row).getOrDefault(player,0) + 1;
        board.getRowsMapping().get(row).put(player, countRows);

        int countCols=board.getColsMapping().get(col).getOrDefault(player,0) + 1;
        board.getColsMapping().get(col).put(player,countCols);



    }

}