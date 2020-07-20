package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class BowllingGameTest {
    @Test
    public void normal_roll_should_return_sum_of_tow_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);
        bowllingGame.roll(4);
        bowllingGame.roll(5);
        //when
        int score = bowllingGame.getScore();
        //then
        Assert.assertEquals(4+5,score);
    }

}
