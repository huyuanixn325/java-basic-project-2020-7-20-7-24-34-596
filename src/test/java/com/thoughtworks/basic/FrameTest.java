package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class FrameTest {

    @Test
    public void roll_should_return_5() {
        //given
        GameFrame frame = new GameFrame();
        frame.roll(5);
        //when
        int score = frame.getScore();
        Assert.assertEquals(5, score);
    }

    @Test
    public void roll_twotimes_should_return_8() {
        //given
        GameFrame frame = new GameFrame();
        frame.roll(5);
        frame.roll(3);
        //when
        int score = frame.getScore();
        Assert.assertEquals(8, score);
    }

    @Test
    public void roll_twotimes_should_return_10() {
        //given
        GameFrame frame = new GameFrame();
        frame.roll(10);
        frame.roll(10);
        //when
        int score = frame.getScore();
        Assert.assertEquals(10, score);
    }
    @Test
    public void roll_threetimes_should_return_8() {
        //given
        GameFrame frame = new GameFrame();
        frame.roll(2);
        frame.roll(6);
        frame.roll(1);
        //when
        int score = frame.getScore();
        Assert.assertEquals(8, score);
    }
}
