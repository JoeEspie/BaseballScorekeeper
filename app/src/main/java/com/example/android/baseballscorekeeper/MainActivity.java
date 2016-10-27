package com.example.android.baseballscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int currentOuts = 0;
    boolean battingState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Changes the current batting team, resets out count
     */
    public void setBattingState(View v) {
        battingState = !battingState;
        currentOuts = 0;
        displayCurrentOuts();
        displayBattingState(battingState);
    }

    /*
     * Displays current batting team
     */
    public void displayBattingState(boolean state) {
        TextView stateView = (TextView) findViewById(R.id.battingState);
        if(state)
            stateView.setText("Team A is batting");
        else
            stateView.setText("Team B is batting");
    }

    /*
     * Displays the current number of outs
     */
    public void displayCurrentOuts() {
        TextView outView = (TextView) findViewById(R.id.numberOuts);
        outView.setText(String.valueOf(currentOuts));
    }

    /*
     * Resets the scores for each team, and out count
     */
    public void resetScores(View v) {
        scoreTeamA = scoreTeamB = currentOuts = 0;
        displayCurrentOuts();
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void runForTeamA(View v) {
        if(battingState)
            scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increments the out total, or changes batting state if 3 outs are counted
     */
    public void out(View v) {
        if(currentOuts < 2)
            currentOuts++;
        else if(currentOuts == 2) {
            currentOuts = 0;
            setBattingState(v);
        }
        displayCurrentOuts();
    }

    /**
     * Increase the score for Team A by 4 points.
     */
    public void grandSlamForTeamA(View v) {
        if(battingState)
            scoreTeamA = scoreTeamA + 4;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void runForTeamB(View v) {
        if(!battingState)
           scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 4 points.
     */
    public void grandSlamForTeamB(View v) {
        if(!battingState)
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
