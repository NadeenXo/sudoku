/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author nadee
 */
public class Sudoku {

    private String SLevel; //progress
    private int score;
    private String time;

    public Sudoku(String progress, int score, String time) {
        this.SLevel = progress;
        this.score = score;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProgress() {
        return SLevel;
    }

    public void setProgress(String progress) {
        this.SLevel = progress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
