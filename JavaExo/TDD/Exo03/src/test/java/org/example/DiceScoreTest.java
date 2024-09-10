package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
    private DiceScore diceScore = Mockito.mock(DiceScore.class);

    @BeforeEach
    public void setup(){
        System.out.println("Avant chaque test");
        DiceScore = new DiceScore();
    }

    @Test
    public void testDiceScore() {

    }



}
