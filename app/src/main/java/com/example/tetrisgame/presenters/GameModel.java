package com.example.tetrisgame.presenters;

import android.content.Context;

public interface GameModel {
    int FPS = 60;
    int SPEED = 25;
    void init();
    int getGameSize();
    void newGame();
    void startGame(PresenterObserver<Point[][]> onGameDrawnListener);
    void pauseGame();
    void turn(GameTurn turn);
    void setGameOverListener(PresenterCompletableObserver onGameOverListener);
    void setScoreUpdatedListener(PresenterObserver<Integer> onScoreUpdatedListener);

    void init(Context context);

    int getHighScore();

    void updateHighScore(int score);
}
