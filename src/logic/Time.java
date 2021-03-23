/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.*;
import javax.swing.Timer;

/**
 *
 * @author nadee
 */
public class Time implements ActionListener {

    public static final int START_MIN = 10;
    public static final int START_SEC = 60;

    static int min = START_MIN;   //if it dosent work delete static..
    static int sec = START_SEC;
    boolean is_started = true;
    public static String curTime = "";
    private final Sudoku sudoku;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timerLogic();
        }
    });

    Time(Sudoku sudoku) {
        this.sudoku = sudoku;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == DisplaySudoku.STARTBUTTON) {
            if (is_started == false) { //if start
                is_started = true;
                start();
                DisplaySudoku.STARTBUTTON.setText("Stop");
                DisplaySudoku.S_PANEL.setVisible(true);

            } else { //if stop
                is_started = false;
                stop();
                DisplaySudoku.STARTBUTTON.setText("Start");
                DisplaySudoku.S_PANEL.setVisible(false);
            }
        }
        if (e.getSource() == DisplaySudoku.RESETBUTTON) {
            is_started = true;
            DisplaySudoku.STARTBUTTON.setText("Stop");
            reset();
        }

    }

    public void start() {

        timer.start();

    }

    public void stop() {

        timer.stop();

    }

    public void reset() {

        timer.stop();
        DisplaySudoku.S_PANEL.setVisible(true);
        min = START_MIN;
        sec = START_SEC;
        timer.start();
        timerLogic();
    }

    private void timerLogic() {
        if (sec > 0) {
            sec--;
            DisplaySudoku.SECONDS.setText(sec + "");
        } else if (sec == 0 && min != 0) {
            sec = START_SEC;
            DisplaySudoku.SECONDS.setText(START_SEC + "");
            min--;
            DisplaySudoku.MINUETS.setText(min + " : ");
            if (min == 0) {
                min = START_MIN;
                DisplaySudoku.MINUETS.setText(START_MIN + " : ");
            }
        }
        if (min <= 0 && sec <= 0) {
            curTime = "0 : 0";
            DisplaySudoku.S_PANEL.setVisible(false);
            DisplaySudoku.MINUETS.setText(0 + " : ");
            DisplaySudoku.SECONDS.setText(0 + "");

        } else {
            curTime = DisplaySudoku.MINUETS.getText() + "" + DisplaySudoku.SECONDS.getText();

        }
    }
}
