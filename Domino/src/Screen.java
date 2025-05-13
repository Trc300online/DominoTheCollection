import java.util.Locale;
import java.util.Scanner;

public class Screen {

    public static void printHands() {
        for (int i = 0; i < Game.getNumberOfPlayers(); i++) {
            for (int j = 0; j < Game.totalPlayers[i].getHand().size(); j++) {
                System.out.print(Game.totalPlayers[i].getHand().get(j) + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void printPlayerHand(int count) {
        for (int j = 0; j < Game.totalPlayers[count].getHand().size(); j++) {
            System.out.print(Game.totalPlayers[count].getHand().get(j) + " ");
        }
    }

    public static void printTable() {
        for (int j = 0; j < Table.getTable().size(); j++) {
            System.out.print(Table.getTable().get(j) + " ");
        }
    }

    public static void spacer() {
        System.out.println();
        System.out.println();
    }

    public static int getPlayers() {
        int nPlayers;
        Scanner getPlayers = new Scanner(System.in);
        System.out.println("Nombre de jugadors: ");
        nPlayers = Integer.parseInt(getPlayers.next());
        return nPlayers;
    }

    public static char getGameMode() {

        char p;
        Scanner getTeam = new Scanner(System.in);
        System.out.println("[I] Individual | [P] Parella");
        p = getTeam.next().toUpperCase().charAt(0);

        return p;
    }

    public static char offerIndvGames() {
        char g;
        Scanner getIndv = new Scanner(System.in);
        System.out.println("[E] Español | [M] Mexica | [X] Xilè");
        g = getIndv.next().toUpperCase().charAt(0);

        return g;
    }

    public static char offerTeamGames() {
        char g;
        Scanner getTeam = new Scanner(System.in);
        System.out.println("[E] Español | [M] Mexica | [L] Llatí | [C] Colombiá | [V] Veneçolá | [X] Xilè | [P] Ponce ");
        g = getTeam.next().toUpperCase().charAt(0);

        return g;
    }

    public static void errorMng(int errorCode) {
        if (errorCode == 1) {
            System.out.println("Nombre de jugadors massa elevat per aquesta aplicació.");
        }
        if (errorCode == 2) {
            System.out.println("No pots colocar cap fitxa");
        }
    }

    public static void jocIndividual(){
        System.out.println("jugadors insuficients per jugar en parelles. Aquestes son les opcions per jocs individuals.");
    }

    public static int askGetTileToPlace() {
        int pos;
        Scanner posScan = new Scanner(System.in);
        System.out.println("Quina fitxa vols colocar");
        pos = Integer.parseInt(posScan.next());

        return pos;
    }

    public static char askGetTablePlacement() {
        Scanner posTable = new Scanner(System.in);
        System.out.println("A quin extrem vols posar la fitxa: [D] Dreta | [E] Esquerra");
        return posTable.next().toUpperCase().charAt(0);
    }
}
