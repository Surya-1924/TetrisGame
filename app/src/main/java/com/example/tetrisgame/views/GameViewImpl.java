package com.example.tetrisgame.views;
//
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.example.tetrisgame.presenters.GameStatus;
//import com.example.tetrisgame.presenters.GameView;
//import com.example.tetrisgame.presenters.Point;
//
//public class GameViewImpl implements GameView {
//    private final GameFrame mGameFrame;
//    private final TextView mGameScoreText;
//    private final TextView mGameStatusText;
//    private final Button mGameCtlBtn;
//    GameViewImpl(GameFrame gameFrame,TextView gameScoreText,TextView gameStatusText,Button gameCtlBtn){
//        mGameFrame = gameFrame;
//        mGameScoreText = gameScoreText;
//        mGameStatusText = gameStatusText;
//        mGameCtlBtn = gameCtlBtn;
//
//    }
//    @Override
//    public void init(int gameSize, int highScore) {
//        mGameFrame.init(gameSize);
//    }
//
//    @Override
//    public void draw(Point[][] points) {
//        mGameFrame.setPoints(points);
//        mGameFrame.invalidate();
//    }
//
//    @Override
//    public void setScore(int score) {
//        mGameScoreText.setText("Score: " + score);
//    }
//
//    @Override
//    public void setStatus(GameStatus status) {
//        mGameStatusText.setText(status.getValue());
//        mGameStatusText.setVisibility(status == GameStatus.PLAYING ? View.INVISIBLE : View.VISIBLE);
//        mGameCtlBtn.setText(status == GameStatus.PLAYING ? "Pause" : "Start");
//    }
//}

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tetrisgame.presenters.GameStatus;
import com.example.tetrisgame.presenters.GameView;
import com.example.tetrisgame.presenters.Point;

public class GameViewImpl implements GameView {
    private final GameFrame mGameFrame;
    private final TextView mGameScoreText;
    private final TextView mGameStatusText;
    private final Button mGameCtlBtn;
    private int mHighScore; // Added member variable to store high score

    GameViewImpl(GameFrame gameFrame,TextView gameScoreText,TextView gameStatusText,Button gameCtlBtn){
        mGameFrame = gameFrame;
        mGameScoreText = gameScoreText;
        mGameStatusText = gameStatusText;
        mGameCtlBtn = gameCtlBtn;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void init(int gameSize, int highScore) {
        mGameFrame.init(gameSize);
        mHighScore = highScore; // Initialize high score
        mGameScoreText.setText("Score: 0 | High Score: " + mHighScore); // Display high score
    }

    @Override
    public void draw(Point[][] points) {
        mGameFrame.setPoints(points);
        mGameFrame.invalidate();
    }

    @Override
    public void setScore(int score) {
        // Compare current score with high score and update if necessary
        if (score > mHighScore) {
            mHighScore = score;
            mGameScoreText.setText("Score: " + score + " | High Score: " + mHighScore);
        } else {
            mGameScoreText.setText("Score: " + score + " | High Score: " + mHighScore);
        }
    }

    @Override
    public void setStatus(GameStatus status) {
        mGameStatusText.setText(status.getValue());
        mGameStatusText.setVisibility(status == GameStatus.PLAYING ? View.INVISIBLE : View.VISIBLE);
        mGameCtlBtn.setText(status == GameStatus.PLAYING ? "Pause" : "Start");
    }

    @Override
    public int getScore() {
        return mHighScore;
    }
}
