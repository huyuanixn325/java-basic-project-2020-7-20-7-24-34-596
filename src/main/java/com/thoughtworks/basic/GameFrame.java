package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

public class GameFrame {
    private List<Integer> rolls;

    public GameFrame() {
        this.rolls = new ArrayList<>();
    }

    public void roll(int i) {
        if (isEnd()){
            if (getScore()==10){
                rolls.add(0);
            }else rolls.add(i);
        }
    }

    public int getScore() {
        int score = 0;
       for (Integer i=0;i<rolls.size();i++){
           score=score+rolls.get(i);
       }
       return score;
    }

    public boolean isEnd(){
        if (rolls.size()>=2)
            return false;
        else return true;
    }
}
