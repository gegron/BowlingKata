package fr.xebia.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoring {

    private List<Throw> throwList = new ArrayList<>();

    private Integer currentThrowIndex;

    public BowlingScoring() {
        for (int i = 0; i < 22; i++) {
            throwList.add(new Throw());
        }

        currentThrowIndex = 0;
    }

    public void addFalledPin(Integer count) {
        Throw currentThrow = retrieveCurrentThrow();

        if (isFirstThrowOfFrame()) {
            currentThrow.setScore(count);

            if (count == 10 && isNotLastFrame()) {
                retrieveNextNextThrow().coeff += retrieveNextThrow().coeff;
                retrieveNextNextNextThrow().coeff++;

                retrieveNextThrow().coeff = 0;

                currentThrowIndex++;
            }
        }
        else {
            currentThrow.setScore(count);

            // SPARE
            if (retrievePreviousThrow().getScore() + currentThrow.getScore() == 10 && isNotLastFrame()) {
                retrieveNextThrow().coeff ++;
            }
        }

        currentThrowIndex++;
    }

    private boolean isNotLastFrame() {
        return currentThrowIndex < 18;
    }

    private boolean isFirstThrowOfFrame() {
        return currentThrowIndex % 2 == 0;
    }

    private Throw retrieveCurrentThrow() {
        return throwList.get(currentThrowIndex);
    }

    private Throw retrievePreviousThrow() {
        return throwList.get(currentThrowIndex - 1);
    }

    private Throw retrieveNextThrow() {
        return throwList.get(currentThrowIndex + 1);
    }

    private Throw retrieveNextNextThrow() {
        return throwList.get(currentThrowIndex + 2);
    }

    private Throw retrieveNextNextNextThrow() {
        return throwList.get(currentThrowIndex + 3);
    }

    public Integer computeScore() {
        Integer score = 0;

        for (Throw currentThrow : throwList) {
            score += currentThrow.computeTotal();
        }

        return score;
    }



}
