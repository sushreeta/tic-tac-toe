package Strategies;

import Models.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    public Move suggestMove(Board board){
        for(int i=0; i<board.getCells().size(); i++){
            for(int j=0; j<board.getCells().size(); j++){
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.FREE)){
                    return new Move(board.getCells().get(i).get(j));
                }
            }
        }
        return null;
    }
}