package fr.xebia.kata.bowling;

public class BowlingScoring {

    private Integer score;

    public BowlingScoring() {
        this.score = 0;
    }

    public void addFalledSpin(Integer count) {
        this.score += count;
    }

    public Integer computeScore() {
        return score;
    }

}
