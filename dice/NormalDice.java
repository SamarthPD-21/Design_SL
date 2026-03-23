package Design_SL.dice;

import java.util.Random;

public class NormalDice implements DiceStrategy {

    private Random random = new Random();

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
