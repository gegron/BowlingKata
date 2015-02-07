package fr.xebia.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoring {

    private List<Frame> frames;

    public BowlingScoring() {
        this.frames = new ArrayList<>();
    }

    public void addFalledSpin(Integer count) {
        if (frames.isEmpty()) {
            addNewFrame(count);
        }
        else {
            Frame lastFrame = frames.get(frames.size() - 1);

            if (lastFrame.isCompleted()) {
                addNewFrame(count);
            }
            else {
                lastFrame.addSecondThrow(count);
            }
        }
    }

    private void addNewFrame(Integer count) {
        this.frames.add(new Frame(count));
    }

    public Integer computeScore() {
        Integer count = 0;
        Frame lastFrame = null;

        for (Frame frame : frames) {
            if (frame.isCompleted()) {
                count += frame.getSum();

                if (lastFrame != null && lastFrame.isSpare()) {
                    count += frame.getFirstThrow();
                }

                lastFrame = frame;
            }

            if (frames.indexOf(frame) >= 10) {
                count += frame.getFirstThrow();
            }
        }

        return count;
    }

}
