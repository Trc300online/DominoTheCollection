public class GamePonce extends Game{

    @Override
    public void playGame() {

    }

    @Override
    public boolean winCond(int points) {
        if (points >= 20) {
            return true;
        }
        return false;
    }
}
