package Models;

import Models.Move;
import Strategies.WinningStrategy;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    int nextPlayerIndex;
    Player winner;
    GameState gameState;
    List<WinningStrategy> winningStrategies;

    private Game(Builder builder){
        if(builder.dimension<3){
            throw new IllegalArgumentException();
        }
        validatePlayers(builder.players);

        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = builder.winningStrategies;

    }

    public static void validatePlayers(List<Player> players){
        Set<Character> characterSet = new HashSet<>();
        int bots = 0;
        for(Player player: players){
            characterSet.add(player.getSymbol());
            if(player.getPlayerType().equals(PlayerType.BOT)) bots++;
        }
        if(bots>1 || characterset.size() != players.size()){
            throw new IllegalArguementException();
        }
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private List<Player> players;
        private int dimension;
        private List<winningstrategy> winningstrategies;

        private Builder(){
            this.players = new ArrayList<>();
            this.winningStrategies = List.of(new RowWinningStrategies(), new ColWinningStrategies());
            this.dimension = 3;

            public void setPlayers(List<Player> players){
                this.players = players;
                return this;
            }

            public void setDimension(int dimension){
                this.dimension = dimension;
                return this;
            }

            public void setWinningStrategies(List<WinningStrategy> winningStrategies){
                this.winningstrategies = setWinningStrategies;
                return this;
            }

            public Game Build(){
                return new Game(this);
            }
        }
    }

}
