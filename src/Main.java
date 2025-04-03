//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BoardController());
        Game game = gameController.startGame();

        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
            // Print the board.
            // Which player turn it is.
            // Make a move.
            gameController.printBoard(game);
            gameController.makeMove(game);
            gameController.checkUndo(game);
        }

        if (gameController.checkState(game).equals(GameState.DRAW)) {
            System.out.println("The game ended in a draw.");
        } else {
            System.out.printf("The player %s won.", gameController.getWinner(game).getName());
        }

    }
}