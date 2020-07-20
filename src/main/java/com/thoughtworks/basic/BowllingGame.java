package com.thoughtworks.basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BowllingGame {
    private int currentFrame;
    private List<GameFrame> gameFrames;
    private int frameSize;
    private List<Integer> frameScores;
    private int lastHits;

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
        if (frameSize == currentFrame + 1 && gameFrames.get(currentFrame).getScore() == 10) {
            lastHits = hits;
        }
            if (!isEnd()&&gameFrames.get(currentFrame).isEnd()){
                currentFrame++;
            }
            if (!isEnd()) {
                gameFrames.get(currentFrame).roll(hits);
            }
    }

    public int getScore() {
        calcauteFrameScores();
        int score = 0;
        for (Integer frameScore : frameScores) {
            score += frameScore;
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
        calcauteFrameScores();
        String result = "";
        for (int i = 0; i <= currentFrame; i++) {
            if (i == 0) {
                result += frameScores.get(i);
            } else {
                result += "|" + frameScores.get(i);
            }
        }
        return result;
    }

    private void calcauteFrameScores() {
        frameScores = new ArrayList<>();
        if (currentFrame == frameSize) {
            currentFrame--;
        }
        for (int i = 0; i <= currentFrame; i++) {
            int frameScore = gameFrames.get(i).getScore();
            if (frameScore == 10) {
                if (i < currentFrame && currentFrame < frameSize) {
                    // 获取下一格的第一次得分
                    frameScore += this.gameFrames.get(i + 1).getScorebyTime(0);
                }
                if (i == currentFrame && i == frameSize - 1) {
                    frameScore += lastHits;
                }
            }
            frameScores.add(frameScore);
        }
    }
}
