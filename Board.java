package Design_SL;
import Design_SL.jump.*;
import java.util.*;

public class Board {

    int size;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;

        this.snakes = JumpFactory.createSnakes(size, size);
        this.ladders = JumpFactory.createLadders(size, size, snakes);
    }

    public int checkJump(int position) {

        if (snakes.containsKey(position)) {
            System.out.println("Bitten by snake! Down to " + snakes.get(position));
            return snakes.get(position);
        }

        if (ladders.containsKey(position)) {
            System.out.println("Climbed ladder! Up to " + ladders.get(position));
            return ladders.get(position);
        }

        return position;
    }
}
// test change
