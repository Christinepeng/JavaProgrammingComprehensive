package Hw3;

public class Die {
    private int sides;
    private int value;

    public Die() {
        this.sides = 6;
    }

    public Die(int sides) {
        this.sides = sides;
    }

    public void roll() {
        this.value = ((int) (Math.random() * sides) + 1);
    }

    public int getValue() {
        this.roll();
        return value;
    }
}
