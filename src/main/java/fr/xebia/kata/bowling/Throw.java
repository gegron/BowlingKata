package fr.xebia.kata.bowling;

public class Throw {
    public Integer coeff;
    public Throw previous;
    public Throw next;

    private Integer frameNumber;

    private Integer score;

    public Throw(Integer frameNumber) {
        this.frameNumber = frameNumber;
        this.coeff = 1;
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer computeTotal() {
        return coeff * score;
    }

    public void addPrevious(Throw previous) {
        this.previous = previous;

        previous.next = this;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean isLastFrame() {
        return frameNumber == 10;
    }

    public boolean isFirstThrowOfFrame() {
        return previous == null || previous.frameNumber != frameNumber;
    }

}
