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
        gameFrames.get(hits).roll(hits);
    }

    public int getScore() {
        int score = 0;
        for (GameFrame gameFrame : gameFrames){
            score = score+gameFrame.getScore();
        }
        return score;
    }
}
