package fr.xebia.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {


    @Test
    public void should_is_a_spare_and_not_a_strike() {
        // Given
        Frame frame = new Frame(6);
        frame.addSecondThrow(4);

        // When / Then
        assertThat(frame.isSpare()).isTrue();
        assertThat(frame.isStrike()).isFalse();
    }

    @Test
    public void should_is_a_strike() {
        // Given
        Frame frame = new Frame(10);

        // When / Then
        assertThat(frame.isSpare()).isFalse();
        assertThat(frame.isStrike()).isTrue();
    }

}