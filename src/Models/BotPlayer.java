package Models;

public class BotPlayer extends Player{
    Level level;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, Character symbol, int id, PlayerType playerType, Level level){
        super(name, symbol, id, playerType);
        this.level = level;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(level);
    }

    @Override
    public Move makemove(){
        //return a move based on bot strategy.
        Move suggestedMove = botPlayingStrategy.suggestMove(board);
        suggestedMove.getCell().setPlayer(this);
        return suggestedMove;
    }

}
