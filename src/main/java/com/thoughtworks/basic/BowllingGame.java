package com.thoughtworks.basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BowllingGame {
    private int currentFrame;
    private List<GameFrame> gameFrames;
    private int frameSize;
    private List<Integer> frameScores;
    public BowllingGame(int gameNumber) {
        this.frameSize = gameNumber;
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
        if (currentFrame>=frameSize) {
            return true;
        }
        if (currentFrame==(frameSize-1)&&this.gameFrames.get(currentFrame).isEnd()&& (!(this.gameFrames.get(currentFrame - 1).getScore() == 10))){
            return true;
        }
        return false;
    }

    public String showFrameScores(){
        String result = "";
        for (int i = 0; i <= currentFrame; i++) {
            if (i == 0) {
                result += gameFrames.get(i).getScore();
            } else {
                result += "|" + gameFrames.get(i).getScore();
            }
        }
        return result;
    }


}
