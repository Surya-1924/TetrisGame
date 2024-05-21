package com.example.tetrisgame.presenters;

public interface GameView {
    void init(int gameSize, int highScore);
    void draw(Point[][] points);
    void setScore(int score);
    void setStatus(GameStatus status);
    int getScore();
}
