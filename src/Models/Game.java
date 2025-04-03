package Models;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    int nextPlayerIndex;
    Player winner;
    GameState gameState;
    List<WinningStrategy> winningStrategies;
}
