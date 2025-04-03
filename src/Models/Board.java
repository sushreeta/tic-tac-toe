package Models;

import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@data
public class Board {

    private List<List<Cell>> cells;
    private List<Map<Player, Integer>> rowsMapping = new ArrayList<>();
    private List<Map<Player, Integer>> colsMapping = new ArrayList<>();

    public Board(int dimension){
         this.cells = new ArrayList<>();
         for(int i=0; i<dimension; i++){
             this.rowsMapping.add(new HashMap<>());
             this.colsMapping.add(new HashMap<>());
        }
        for(int i=0; i<dimension; i++){
            this.cells.add(new ArrayList<>());
            for(int j=0; j< dimension; j++){
                this.cells.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display(){
        for(int i=0; i<cells.size(); i++){
            for(int j=0; j<cells.size(); j++){
                if(cells.get(i).get(j).getCellState().equals(CellState.FREE)) {
                    System.out.printf("| |");
                } else {
                    System.out.printf("| %s |", cells.get(i).get(j).getPlayer().getSymbol());
                }
            }
            System.out.println();
        }
    }

}
