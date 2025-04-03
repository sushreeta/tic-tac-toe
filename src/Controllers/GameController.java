public class GameController {
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
            playerList.add(new Player(name, symbol, i, playerType));
        }

        Game.getBuilder().set.build();
    }
}