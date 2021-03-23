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
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import ui.*;
import static logic.Time.START_MIN;
import static logic.Time.START_SEC;

public class DisplaySudoku extends JFrame {

    ImageIcon image = new ImageIcon("C:\\Users\\nadee\\Desktop\\TheBigProject\\src\\com\\SProject\\logo.png");
    //constant fields
    private final Font NumbersFont = new Font("Times New Roman", Font.PLAIN, 17);
    private final Dimension bigDimention = new Dimension(75, 25);
    private final Dimension smallDimention = new Dimension(35, 30);
    private final Color backGroundColor = new Color(204, 204, 204);

    private final int is_Open = 0;  //if the cell opend or not
    private final int grid_size = 9;

    public static int ScoreVariable;
    public static String timerValue = "";

    //the puzzle
    private JTextField[][] cells = new JTextField[grid_size][grid_size];
    //lable
    static JLabel MINUETS;
    static JLabel SECONDS;
    static JLabel name;
    //buttons
    static JButton STARTBUTTON;
    static JButton RESETBUTTON;
    JButton checkBtn;
    JButton exitBtn;
    // panels
    static JPanel S_PANEL; //sudoku panel
    JPanel upperPanel;

    private final int[][] userSudoku;
    private final int[][] answerSudoku;

    private Time time;
    private Sudoku sudoku;

    public DisplaySudoku(int[][] userSudoku, int[][] answerSudoku, Sudoku sudoku, User user) {
        this.userSudoku = userSudoku;
        this.answerSudoku = answerSudoku;
        this.sudoku = sudoku;
        time = new Time(this.sudoku);   //instance of the timer 
        ScoreVariable = 0;
        //Lables
        MINUETS = new JLabel(START_MIN + " : ");
        SECONDS = new JLabel(START_SEC + "");
        name = new JLabel("name: " + LoginPage.user.getName()); //player name
        //Buttons
        STARTBUTTON = new JButton("Stop");
        RESETBUTTON = new JButton("Reset");
        exitBtn = new JButton("Exit");
        checkBtn = new JButton("Check");
        // soduku panel
        S_PANEL = new JPanel();
        S_PANEL.setLayout(new GridLayout(grid_size, grid_size));

        upperPanel = new JPanel();

        //add cells to the S_PANEL 
        puzzle();

        S_PANEL.setPreferredSize(new Dimension(600, 600));
        this.setLayout(new BorderLayout());
        this.add(S_PANEL, BorderLayout.CENTER);
        this.add(upperPanel, BorderLayout.NORTH);

        MINUETS.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        SECONDS.setFont(NumbersFont);

        MINUETS.setPreferredSize(smallDimention);
        SECONDS.setPreferredSize(smallDimention);
        name.setPreferredSize(new Dimension(150, 25));

        STARTBUTTON.setPreferredSize(bigDimention);
        STARTBUTTON.setFocusable(false);

        RESETBUTTON.setPreferredSize(bigDimention);
        RESETBUTTON.setFocusable(false);

        checkBtn.setPreferredSize(bigDimention);
        checkBtn.setFocusable(false);

        exitBtn.setPreferredSize(bigDimention);
        exitBtn.setFocusable(false);

        upperPanel.add(MINUETS);
        upperPanel.add(SECONDS);
        upperPanel.add(name);
        upperPanel.add(RESETBUTTON);
        upperPanel.add(STARTBUTTON);
        upperPanel.add(checkBtn);
        upperPanel.add(exitBtn);

        //actions
        exitBtn.addActionListener((ActionEvent e) -> {
            exitMethod();
        });
        STARTBUTTON.addActionListener(time);
        RESETBUTTON.addActionListener(time);
        RESETBUTTON.addActionListener((ActionEvent e) -> {
            if (e.getSource() == RESETBUTTON) {
                for (int row = 0; row < grid_size; ++row) {
                    for (int column = 0; column < grid_size; ++column) {
                        if (userSudoku[row][column] != is_Open) { //set sudoku numbers
                            cells[row][column].setText(answerSudoku[row][column] + "");
                            cells[row][column].setEditable(false);
                            cells[row][column].setBackground(backGroundColor);
                            cells[row][column].setForeground(Color.BLACK);
                        } else {
                            cells[row][column].setText("");     // set to empty string
                            cells[row][column].setEditable(true);
                            cells[row][column].setBackground(Color.WHITE);
                            cells[row][column].setForeground(Color.BLUE);
                        }
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
        setTitle("SUDOKU");
        this.setIconImage(image.getImage()); //change icon of frame
        setVisible(true);
        pack();
    }

    private void puzzle() {
        //add cells to the S_PANEL 
        for (int row = 0; row < grid_size; ++row) {
            for (int column = 0; column < grid_size; ++column) {
                cells[row][column] = new JTextField();
                // Beautify all the cells
                S_PANEL.add(cells[row][column], BorderLayout.CENTER);
                cells[row][column].setHorizontalAlignment(JTextField.CENTER);
                cells[row][column].setFont(new Font("Monospaced", Font.BOLD, 20));
                time.start();

                if (userSudoku[row][column] != is_Open) { //set sudoku numbers to the cells
                    cells[row][column].setText(answerSudoku[row][column] + "");
                    cells[row][column].setEditable(false);
                    cells[row][column].setBackground(backGroundColor);
                    cells[row][column].setForeground(Color.BLACK);
                } else {
                    cells[row][column].setText("");     // set empty cells
                    cells[row][column].setEditable(true);
                    cells[row][column].setBackground(Color.WHITE);
                    cells[row][column].setForeground(Color.BLUE);
                }
                checkBtn.addActionListener((ActionEvent e) -> {
                    checkMethod(); //check method
                });
                cells[row][column].addActionListener((ActionEvent e) -> {
                    checkMethod(); //check method
                });
            }
        }
    }

    public void checkMethod() {
        int inp;
        for (int row1 = 0; row1 < grid_size; ++row1) {
            for (int column1 = 0; column1 < grid_size; ++column1) {
                if (userSudoku[row1][column1] == is_Open && !(cells[row1][column1].getText().isEmpty())) {
                    inp = Integer.parseInt(cells[row1][column1].getText().replaceAll("[^0-9]", ""));
                    if (inp == answerSudoku[row1][column1]) {         //right solution
                        cells[row1][column1].setBackground(backGroundColor); //if it is red change it
                        cells[row1][column1].setEditable(false); //don't change the right answer
                        //cells[row1][column1].setForeground(Color.BLUE);

                    } else {
                        cells[row1][column1].setBackground(Color.red);
                    }
                }
            }
        }
    }

    public void exitMethod() {
        int inp;
        for (int row1 = 0; row1 < grid_size; ++row1) {
            for (int column1 = 0; column1 < grid_size; ++column1) {
                if (userSudoku[row1][column1] == is_Open && !(cells[row1][column1].getText().isEmpty())) {
                    inp = Integer.parseInt(cells[row1][column1].getText().replaceAll("[^0-9]", ""));
                    if (inp == answerSudoku[row1][column1]) {
                        ScoreVariable += 5;

                    }
                }
            }
        }
        sudoku.setScore(ScoreVariable);
        timerValue = Time.curTime;
        sudoku.setTime(timerValue);
        JOptionPane.showMessageDialog(this, "Your score is " + ScoreVariable);
        this.setVisible(false);
        time.reset();
        time.stop();
    }
}
