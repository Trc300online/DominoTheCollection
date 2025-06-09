package SaveAndLoad;

import java.io.*;

public class GameDAOImpl implements GameDAO{

    @Override
    public void saveGame(GameState gameState, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(gameState);
            System.out.println("Partida guardada correctament.");
        } catch (IOException e) {
            System.err.println("Error al guardar la partida: " + e.getMessage());
        }
    }

    @Override
    public GameState loadGame(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Partida carregada correctament.");
            return (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al carregar la partida: " + e.getMessage());
            return null;
        }
    }
}
