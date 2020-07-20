package com.thoughtworks.basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BowllingGame {
    private int currentFrame;
    private List<GameFrame> gameFrames;
    public BowllingGame(int gameNumber) {
        this.initFrame(gameNumber);
    }
    public void initFrame(int gameNumber){
        this.currentFrame = 0;
        this.gameFrames = new ArrayList<>();
        for (int i =0;i<gameNumber;i++){
            gameFrames.add(new GameFrame());
        }
    }

    public void roll(int hits) {
            if (!isEnd()&&gameFrames.get(currentFrame).isEnd()){
                currentFrame++;
            }
            if (!isEnd()) {
                gameFrames.get(currentFrame).roll(hits);
            }
    }

    public int getScore() {
        int score = 0;
        for (GameFrame gameFrame : gameFrames){
            score = score+gameFrame.getScore();
        }
        return score;
    }

    public boolean isEnd() {
        if (currentFrame>=10) {
            return true;
        }
        return false;
    }
}
