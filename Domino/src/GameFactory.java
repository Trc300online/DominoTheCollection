public class GameFactory {

    public static Game createGame(char gameType) {
        switch (gameType) {
            case 'M':
            case 'E':
                return new GameEspMex();
            case 'L':
                return new GameLlati();
            case 'C':
            case 'V':
                return new GameColVen();
            case 'X':
                return new GameXile();
            case 'P':
                return new GamePonce();
            default:
                throw new IllegalArgumentException("Game type not supported: " + gameType);
        }
    }
}
