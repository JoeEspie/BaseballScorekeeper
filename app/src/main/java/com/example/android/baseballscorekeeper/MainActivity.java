package com.example.android.baseballscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int currentOutsTeamA = 0;
    int getCurrentOutsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resetScores(View v) {
        scoreTeamA = scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void runForTeamA(View v) {
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void outForTeamA(View v) {
        currentOutsTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void grandSlamForTeamA(View v) {
        scoreTeamA = scoreTeamA + 4;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void runForTeamB(View v) {
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void outForTeamB(View v) {
        getCurrentOutsTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void grandSlamForTeamB(View v) {
        scoreTeamB = scoreTeamB + 4;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
