package fr.xebia.kata.bowling;

import com.google.common.collect.Lists;

public class Frame {

    private final static Integer STRIKE_VALUE = -1;
    private final static Integer BONUS_VALUE = -2;

    private Integer firstThrow;
    private Integer secondThrow;

    public Frame(Integer firstThrow) {
        this.firstThrow = firstThrow;

        if (firstThrow == 10) {
            secondThrow = STRIKE_VALUE;
        }
    }

    public Frame makeBonusFrame(Integer firstThrow) {
        Frame frame = new Frame(firstThrow);
        frame.secondThrow = STRIKE_VALUE;

        return frame;
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
        if (isCompleted()) {
            return firstThrow + secondThrow == 10;
        }
        else {
            return false;
        }
    }

    public boolean isStrike() {
        return STRIKE_VALUE.compareTo(secondThrow) == 0;
    }

    public boolean isCompleted() {
        return firstThrow != null && secondThrow != null;
    }

    public Integer getSum() {
        if (!isCompleted() || Lists.newArrayList(STRIKE_VALUE, BONUS_VALUE).contains(secondThrow)) {
            return firstThrow;
        }
        else {
            return firstThrow + secondThrow;
        }
    }
}
