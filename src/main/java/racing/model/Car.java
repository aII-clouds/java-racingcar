package racing.model;

import java.util.Random;

public class Car {

    private static final int DEFAULT_CRITERION = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int DEFAULT_BOUND = 10;

    private final CarName name;
    private final int criterion;
    private int position;

    public Car(final String name) {
        this(name, DEFAULT_CRITERION, DEFAULT_POSITION);
    }

    public Car(final String name, final int criterion, final int position) {
        this.name = new CarName(name);
        this.criterion = criterion;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getCriterion() {
        return criterion;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinner(final int maxPosition) {
        return this.position == maxPosition;
    }

    public boolean matchPosition(final int target) {
        return this.position == target;
    }

    public void move(final Random random) {
        final int randomValue = random.nextInt(DEFAULT_BOUND);
        move(randomValue);
    }

    private void move(final int power) {
        if (canMove(power)) {
            this.position++;
        }
    }

    private boolean canMove(final int value) {
        return value >= this.criterion;
    }
}
