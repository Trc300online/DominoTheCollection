public abstract class Game {

    protected static int numberOfPlayers;
    protected static Player[] team1;
    protected static Player[] team2;
    protected static Player[] players;
    protected static char mode;
    protected static char gameType;
    protected static char[] checkType = {'E','M','L','C','V','X','P'};
    static int counter = 0;
    protected Table mesa;
    protected Bag bossa;
    protected Screen screen;

    public static int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public Game() {
        this.mesa = new Table();
        this.bossa = new Bag();
        this.screen = new Screen();

        numberOfPlayers = Screen.getPlayers();
        if (numberOfPlayers>4) {
            Screen.errorMng(1);
            System.exit(1);
        }
        mode = (numberOfPlayers < 4) ? 'I' : Screen.getGameMode();
        gameType = (mode == 'I') ? Screen.offerIndvGames() : Screen.offerTeamGames();
        for (int i = 0; i < checkType.length; i++) {
            if (gameType != checkType[i]) {
                counter++;
                if (counter >= checkType.length) {
                    Screen.errorMng(3);
                    System.exit(1);
                }
            }
        }

        players = new Player[numberOfPlayers];
        team1 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
        team2 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
    }

    public static void setUpGame() {

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            players[i] = player;

            if (mode != 'I') {
                if (i % 2 == 0) {
                    team1[i / 2] = player;
                } else {
                    team2[i / 2] = player;
                }
            }
        }
    }

    public boolean canPlaceTileOnTable(int count) {

        if (mesa.isTableEmpty()) {
            return true;
        }

        int farDreta = mesa.getFarDreta();
        int farEsquerra = mesa.getFarEsquerra();

        for (int i = 0; i < players[count].getHand().size(); i++) {
            Tile tile = players[count].getHand().get(i);
            if (tile.getDreta() == farDreta || tile.getEsquerra() == farDreta ||
                    tile.getDreta() == farEsquerra || tile.getEsquerra() == farEsquerra) {
                return true;
            }
        }
        return false;
    }

    public abstract void playGame();

    public abstract boolean winCond(int points);
}
