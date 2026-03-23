package Design_SL;
import Design_SL.dice.*;
import java.util.*;

public class Game {

    private Queue<Player> players;
    private Board board;
    private DiceStrategy dice;
    private int boardSize;

    public Game(int n, List<String> playerNames) {

        this.boardSize = n;

        this.board = new Board(n);

        // Strategy + Decorator applied
        this.dice = new LoggingDiceDecorator(new NormalDice());

        this.players = new LinkedList<>();

        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public void startGame() {

        int finalCell = boardSize * boardSize;

        while (players.size() > 1) {

            Player player = players.poll();

            int diceValue = dice.roll();

            int newPosition = player.position + diceValue;

            if (newPosition > finalCell) {
                newPosition = player.position;
                System.out.println("Move exceeds board limit.");
            }

            newPosition = board.checkJump(newPosition);
            player.position = newPosition;

            System.out.println(player.name + " is at " + newPosition);

            if (newPosition == finalCell) {
                System.out.println("\n🏆 " + player.name + " wins!");
            } else {
                players.add(player);
            }
        }

        System.out.println("Game finished.");
    }
}
