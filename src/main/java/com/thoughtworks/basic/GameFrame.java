package com.thoughtworks.basic;

import java.util.List;

public class GameFrame {
    private List<Integer> rolls;

    public GameFrame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public void roll(int i) {
        rolls.add(i);
    }

    public int getScore() {
        int score = 0;
       for (Integer i=0;i<rolls.size();i++){
           score=score+rolls.get(i);
       }
       return score;
    }
}
