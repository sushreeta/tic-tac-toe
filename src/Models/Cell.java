package Models;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.FREE;
    }
}
