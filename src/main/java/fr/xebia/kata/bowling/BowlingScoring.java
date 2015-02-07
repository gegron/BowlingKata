package fr.xebia.kata.bowling;

public class BowlingScoring {

    private Throw currentThrow;

    private Throw firstThrow;

    public BowlingScoring() {
        this.currentThrow = this.firstThrow = new Throw(1);

        // Init list
        Throw previous = currentThrow;

        for (int i = 1; i < 21; i++) {
            Throw current = new Throw(Math.min(i / 2 + 1, 10));

            current.addPrevious(previous);
            previous = current;
        }
    }

    public void addFalledPin(Integer count) {
        currentThrow.setScore(count);

        if (currentThrow.isFirstThrowOfFrame()) {

            if (isAStrike(count)) {
                currentThrow.next.next.coeff += currentThrow.next.coeff;
                currentThrow.next.next.next.coeff++;
                currentThrow.next.coeff = 0;

                currentThrow = currentThrow.next;
            }
        }
        else {
            if (isASpare()) {
                currentThrow.next.coeff++;
            }
        }

        currentThrow = currentThrow.next;
    }

    private boolean isAStrike(Integer count) {
        return count == 10 && !currentThrow.isLastFrame();
    }

    private boolean isASpare() {
        return currentThrow.previous.getScore() + currentThrow.getScore() == 10 && !currentThrow.isLastFrame();
    }

    public Integer computeScore() {
        Integer score = 0;

        Throw current = firstThrow;

        while (current != null) {
            score += current.computeTotal();
            current = current.next;
        }

        return score;
    }

}
