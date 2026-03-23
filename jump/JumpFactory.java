package Design_SL.jump;

import java.util.*;

public class JumpFactory {

    public static Map<Integer, Integer> createSnakes(int n, int boardSize) {
        Map<Integer, Integer> snakes = new HashMap<>();
        Random random = new Random();

        while (snakes.size() < n) {
            int head = random.nextInt(boardSize * boardSize - 1) + 2;
            int tail = random.nextInt(head - 1) + 1;

            if (!snakes.containsKey(head)) {
                snakes.put(head, tail);
            }
        }
        return snakes;
    }

    public static Map<Integer, Integer> createLadders(int n, int boardSize, Map<Integer, Integer> snakes) {
        Map<Integer, Integer> ladders = new HashMap<>();
        Random random = new Random();

        while (ladders.size() < n) {
            int start = random.nextInt(boardSize * boardSize - 1) + 1;
            int end = random.nextInt(boardSize * boardSize - start) + start + 1;

            if (!ladders.containsKey(start) && !snakes.containsKey(start)) {
                ladders.put(start, end);
            }
        }
        return ladders;
    }
}
