package Design_SL;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter board size:");
        int n = sc.nextInt();

        System.out.println("Enter number of players:");
        int p = sc.nextInt();
        sc.nextLine();

        List<String> players = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            System.out.println("Enter player name:");
            players.add(sc.nextLine());
        }

        Game game = new Game(n, players);
        game.startGame();
    }
}// test change
