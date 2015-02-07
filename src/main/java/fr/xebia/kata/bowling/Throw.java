package fr.xebia.kata.bowling;

public class Throw {
    public Integer coeff;
    private Integer score;

    public Throw() {
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

}
