package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class FrameTest {

    @Test
    public void roll_should_return_5() {
        //given
        List<Integer> rolls = new ArrayList<>();
        GameFrame frame = new GameFrame(rolls);
        frame.roll(5);
        //when
        int score = frame.getScore();
        Assert.assertEquals(5, score);
    }

    @Test
    public void roll_twotimes_should_return_8() {
        //given
        List<Integer> rolls = new ArrayList<>();
        GameFrame frame = new GameFrame(rolls);
        frame.roll(5);
        frame.roll(3);
        //when
        int score = frame.getScore();
        Assert.assertEquals(8, score);
    }
}
