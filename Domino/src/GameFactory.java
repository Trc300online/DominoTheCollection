public class GameFactory {

    public static Game createGame(char gameType, int numberOfPlayers, char mode) {
        switch (gameType) {
            case 'M':
            case 'E':
                return new GameEspMex(numberOfPlayers, mode, gameType);
            case 'L':
                return new GameLlati(numberOfPlayers, mode, gameType);
            case 'C':
            case 'V':
                return new GameColVen(numberOfPlayers, mode, gameType);
            case 'X':
                return new GameXile(numberOfPlayers, mode, gameType);
            case 'P':
                return new GamePonce(numberOfPlayers, mode, gameType);
            default:
                throw new IllegalArgumentException("Game type not supported: " + gameType);
        }
    }
}
