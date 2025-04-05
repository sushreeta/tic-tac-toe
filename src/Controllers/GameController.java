public class GameController {
    private final BoardController boardController;

    public GameController(BoardController boardController){
        this.boardController = boardController;
    }

    public Game StartGame(){
        System.out.println("Game is Starting...");

        System.out.println("What size of the board you want to play on?");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Board board = new Board(N);

        System.out.println("What are the number of players?");
        int players = sc.nextInt();

        List<Player> playerList = new ArrayLIst<>();
        for(int i=0; i<players; i++){
            System.out.println("Name?");
            String name = sc.next();
            System.out.println("Symbol?");
            Character symbol = sc.next().charAt(0);
            System.out.println("Is the player a bot? (Y/N)");
            Character choice = sc.next().charAt(0);
            PlayerType playerType = choice=="y"? PlayerType.BOT : PlayerType.HUMAN;
            if(playerType.equals(PlayerType.BOT)){
                //Add a bot player based on the level input
                System.out.println("Please enter the level of the bot: ");
                int level = sc.nextInt();
                Level botLevel;
                switch(level){
                    case 1: {
                        botLevel = Level.EASY;
                        break;
                    }
                    case 2: {
                        botLevel = Level.MEDIUM;
                        break;
                    }
                    default: botLevel = Level.HARD;
                }
                playerList.add(new BotPlayer(name, symbol, i, playerType, botLevel));
            } else {
                // Add a human player
                playerList.add(new Player(name, symbol, i, playerType));
            }
        }

        return Game.getBuilder().setDimension(N).setPlayers(playerList).build();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.getBoard.display();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void makeMove(){
        boolean isEmpty = checkAtLeastOneEmptySpace(game.getBoard());
        if(!isEmpty){
            game.setGameState(GameState.DRAW);
            return;
        }
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
        System.out.printf("It's player %s move.", currentPlayer.getName());

        //Logic for the player to make a move
        //1. Get the move for the player(bot/human)
        Move purposedMove = currentPlayer.makeMove();
        //2. placing the move on the board.
        boardController.applyMove(purposedMove, game.getBoard();
        game.getMoves().add(purposedMove);

        //Check winning strategies and alter the state if changed
        if(checkWin(game.getWinningStrategies(), game.getBoard(), proposedMove)){
            game.setGameState(GameState.WIN);
            game.getWinner(currentPlayer);
        }

        game.setNextPlayerIndex(game.getNextPlayerindex() + 1) % game.getPlayers.size());
    }

    private boolean checkAtLeastOneEmptySpace(Board board){
        int rows = board.getCells()size();
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                if(board.getCells().get(i).get(j).getCellState().equals(cellState.FREE)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWin(List<winningstrategy> winningStrategies){
        for(WinningStrategy ws: winningStategies){
            if(ws.checkWin(board, move)) {
                return true;
            }
        }
        return false;
    }

    private void checkUndo(Game game){
        System.out.println("Would you like to undo the last move? (y/n)");
        Scanner sc = new Scanner(System.in);
        String inputUndo = sc.next();

        if(inputUndo.equals("y")){
            //remove the move
            Move move = game.getMoves().remove(game.getMoves().size() - 1);

            //Update player
            int n = game.getPlayers().size();
            game.setNextPlayerIndex(((game.getNextPlayerIndex() -1) + n) % n);

            //Erase the cell from board
            int row = move.getCells().getRow();
            int col = move.getCells().getCol();
            Cell cell = game.getBoard().getCells().get(row).get(col);
            cell.setCellState(CellState.FREE);
            cell.setPlayer(null);
            // updating mappings row and col
            Map<Player,Integer> rowMapping = game.getBoard().getRowsMapping().get(row);
            rowMapping.put(move.getCell().getPlayer(), rowMapping.get(move.getCell().getlayer()) -1 );
            Map<Player,Integer> colMapping = game.getBoard().getRowsMapping().get(col);
            colMapping.put(move.getCell().getPlayer(), colMapping.get(move.getCell().getlayer()) -1 );



        }
    }

}