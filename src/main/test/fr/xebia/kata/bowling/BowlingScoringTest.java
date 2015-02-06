package fr.xebia.kata.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingScoringTest {

    @Test
    public void should_initialize_bowling_scoring() {
        // Given / When
        BowlingScoring bowlingScoring = new BowlingScoring();

        // Then
        assertThat(bowlingScoring.computeScore()).isEqualTo(0);
    }

    @Test
    public void should_add_pin_for_first_frame() {
        // Given
        BowlingScoring bowlingScoring = new BowlingScoring();

        // When
        bowlingScoring.addFalledSpin(5);

        // Then
        assertThat(bowlingScoring.computeScore()).isEqualTo(5);
    }


}