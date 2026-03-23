package Design_SL.dice;

public class LoggingDiceDecorator implements DiceStrategy {

    private DiceStrategy dice;

    public LoggingDiceDecorator(DiceStrategy dice) {
        this.dice = dice;
    }

    @Override
    public int roll() {
        int value = dice.roll();
        System.out.println("🎲 Dice rolled: " + value);
        return value;
    }
}
