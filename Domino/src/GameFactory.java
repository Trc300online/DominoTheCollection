public class GameFactory {

    public static Game createGame(char gameType, char mode) {
        switch (gameType) {
            case 'M':
                return new GameMexica(mode);
            case 'E':
                return new GameEspañol(mode);
            case 'L':
                return new GameLlati(mode);
            case 'C':
                return new GameColombia(mode);
            case 'V':
                return new GameVeneçola(mode);
            case 'X':
                return new GameXile(mode);
            case 'P':
                return new GamePonce(mode);
            default:
                throw new IllegalArgumentException("Game type not supported: " + gameType);
        }
    }
}
