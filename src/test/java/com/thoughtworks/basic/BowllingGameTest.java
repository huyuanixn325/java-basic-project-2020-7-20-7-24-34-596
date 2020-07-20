package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        assertEquals(4+5,score);
    }


    @Test
    public void normal_roll_should_return_12_of_three_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);
        bowllingGame.roll(4);
        bowllingGame.roll(5);
        bowllingGame.roll(3);
        //when
        int score = bowllingGame.getScore();
        //then
        assertEquals(4+5+3,score);
    }

    @Test
    public void normal_roll_should_return_22_of_three_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);
        bowllingGame.roll(4);
        bowllingGame.roll(5);
        bowllingGame.roll(10);
        bowllingGame.roll(2);
        bowllingGame.roll(3);
        //when
        int score = bowllingGame.getScore();
        //then
        assertEquals(4+5+10+3+3,score);
    }


    @Test
    public void should_return_50_when_given_of_20_rolls() {
        //given
        BowllingGame bowlingGame = new BowllingGame(10);

        //when
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);

        //then
        assertEquals(50, bowlingGame.getScore());
    }

    @Test
    public void should_return_true_when_given_of_three_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);

        //when
        for (int i = 0; i < 20; i++) {
            bowllingGame.roll(0);
        }

        //then
        Assert.assertTrue(bowllingGame.isEnd());
    }


    @Test
    public void should_return_10_when_given_of_2_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);

        //when
        bowllingGame.roll(5);
        bowllingGame.roll(5);

        //then
        assertEquals(10, bowllingGame.getScore());
        assertEquals("10", bowllingGame.showFrameScores());
    }


    @Test
    public void should_return_20_when_given_of_three_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);

        //when
        bowllingGame.roll(5);
        bowllingGame.roll(5);
        bowllingGame.roll(5);


        //then
        assertEquals(20, bowllingGame.getScore());
        assertEquals("15|5", bowllingGame.showFrameScores());
    }

    @Test
    public void should_return_150_when_given_21_rolls() {
        //given
        BowllingGame bowllingGame = new BowllingGame(10);

        //when
        for(int i =0;i<21;i++){
            bowllingGame.roll(5);
        }

        //then
        assertEquals(150, bowllingGame.getScore());
        assertEquals("15|15|15|15|15|15|15|15|15|15", bowllingGame.showFrameScores());
    }
}
