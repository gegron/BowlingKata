package fr.xebia.kata.bowling;

public class Frame {

    private final static Integer STRIKE_VALUE = -1;

    private Integer firstThrow;
    private Integer secondThrow;

    public Frame(Integer firstThrow) {
        this.firstThrow = firstThrow;

        if (firstThrow == 10) {
            secondThrow = STRIKE_VALUE;
        }
    }

    public void addSecondThrow(Integer secondThrow) {
        if (this.secondThrow == null) {
            this.secondThrow = secondThrow;
        }
        else {
            throw new UnsupportedOperationException("Second throw already initialized");
        }
    }

    public Integer getFirstThrow() {
        return firstThrow;
    }

    public Integer getSecondThrow() {
        return secondThrow;
    }

    public boolean isSpare() {
        if (firstThrow != null && firstThrow != null) {
            return firstThrow + secondThrow == 10;
        }
        else {
            return false;
        }
    }

    public boolean isStrike() {
        return STRIKE_VALUE.compareTo(secondThrow) == 0;
    }
}
