package Hw3;

public class PairOfDice {
    public int value1, value2, sum;
    public Die Die1, Die2;

    public PairOfDice() {
        this.Die1 = new Die();
        this.Die2 = new Die();
    }

    public PairOfDice(int sides) {
        this.Die1 = new Die(sides);
        this.Die2 = new Die(sides);
    }

    public void roll() {
        this.value1 = Die1.getValue();
        this.value2 = Die2.getValue();
        sum = value1 + value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getSum() {
        return sum;
    }
}
