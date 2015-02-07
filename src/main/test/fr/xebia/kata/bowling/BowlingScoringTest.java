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
        bowlingScoring.addFalledPin(5);

        // Then
        assertThat(bowlingScoring.computeScore()).isEqualTo(5);
    }

//    @Test
//    public void should_add_spare_on_three_frame() {
//        // Given
//        BowlingScoring bowlingScoring = new BowlingScoring();
//        bowlingScoring.addFalledPin(1);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(5);
//        bowlingScoring.addFalledPin(6);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(5);
//
//        // When
//        Integer score = bowlingScoring.computeScore();
//
//        // Then
//        assertThat(score).isEqualTo(29);
//    }

//    @Test
//    public void should_add_spare_on_fourth_frame() {
//        // Given
//        BowlingScoring bowlingScoring = new BowlingScoring();
//        bowlingScoring.addFalledPin(1);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(5);
//        bowlingScoring.addFalledPin(6);
//        bowlingScoring.addFalledPin(4);
//        bowlingScoring.addFalledPin(5);
//        bowlingScoring.addFalledPin(5);
//        bowlingScoring.addFalledPin(10);
//
//        // When
//        Integer score = bowlingScoring.computeScore();
//
//        // Then
//        assertThat(score).isEqualTo(49);
//    }

    @Test
    public void should_check_when_only_one_pin_each_step() {
        // Given
        BowlingScoring bowlingScoring = new BowlingScoring();

        for (int i = 0; i < 20; i++) {
            bowlingScoring.addFalledPin(1);
        }

        // When
        Integer score = bowlingScoring.computeScore();

        // Then
        assertThat(score).isEqualTo(20);
    }
    
    @Test
    public void should_check_when_only_spare() {
        // Given
        BowlingScoring bowlingScoring = new BowlingScoring();

        for (int i = 0; i < 21; i++) {
            bowlingScoring.addFalledPin(5);
        }

        // When
        Integer score = bowlingScoring.computeScore();

        // Then
        assertThat(score).isEqualTo(150);
    }

    @Test
    public void should_check_when_only_strike() {
        // Given
        BowlingScoring bowlingScoring = new BowlingScoring();
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);

        bowlingScoring.addFalledPin(10);
        bowlingScoring.addFalledPin(10);

        // When
        Integer score = bowlingScoring.computeScore();

        // Then
        assertThat(score).isEqualTo(300);
    }

    
    

}