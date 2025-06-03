public class GameFactory {

    public static Game createGame(char gameType, int numberOfPlayers, char mode, Screen screen) {
        switch (gameType) {
            case 'M':
            case 'E':
                return new GameEspMex(numberOfPlayers, mode, gameType, screen);
            case 'L':
                return new GameLlati(numberOfPlayers, mode, gameType, screen);
            case 'C':
            case 'V':
                return new GameColVen(numberOfPlayers, mode, gameType, screen);
            case 'X':
                return new GameXile(numberOfPlayers, mode, gameType, screen);
            case 'P':
                return new GamePonce(numberOfPlayers, mode, gameType, screen);
            default:
                throw new IllegalArgumentException("Game type not supported: " + gameType);
        }
    }
}
