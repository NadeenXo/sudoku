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
public class SudokuLevels {

    private int[][] userSudoku = null;
    private int[][] answerSudoku = null;

    private Sudoku sudoku;
    private DisplaySudoku ds;

    public void easy(User user) {
        userSudoku = new int[][]{
            {7, 3, 0, 8, 0, 5, 1, 6, 0},
            {0, 0, 5, 2, 0, 0, 0, 0, 0},
            {0, 1, 9, 0, 6, 0, 0, 3, 0},
            {1, 0, 7, 3, 0, 0, 2, 0, 4},
            {3, 0, 2, 5, 1, 9, 0, 0, 7},
            {0, 6, 8, 0, 0, 4, 9, 0, 0},
            {0, 2, 6, 1, 0, 0, 3, 4, 5},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 3, 6, 5, 0, 8, 0, 0}};

        answerSudoku = new int[][]{
            {7, 3, 4, 8, 9, 5, 1, 6, 2},
            {6, 8, 5, 2, 3, 1, 4, 7, 9},
            {2, 1, 9, 4, 6, 7, 5, 3, 8},
            {1, 9, 7, 3, 8, 6, 2, 5, 4},
            {3, 4, 2, 5, 1, 9, 6, 8, 7},
            {5, 6, 8, 7, 2, 4, 9, 1, 3},
            {9, 2, 6, 1, 7, 8, 3, 4, 5},
            {8, 5, 1, 9, 4, 3, 7, 2, 6},
            {4, 7, 3, 6, 5, 2, 8, 9, 1}};

        sudoku = new Sudoku("easy", 0, "");
        user.setSudokus(sudoku);
        ds = new DisplaySudoku(userSudoku, answerSudoku, sudoku, user);
    }

    public void medium(User user) {
        userSudoku = new int[][]{
            {9, 6, 0, 4, 0, 1, 3, 0, 0},
            {0, 7, 0, 9, 0, 0, 5, 6, 0},
            {0, 0, 0, 7, 0, 0, 0, 2, 0},
            {4, 0, 6, 1, 0, 0, 0, 0, 0},
            {0, 0, 8, 0, 6, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 8, 1, 0, 6},
            {5, 0, 0, 6, 0, 7, 9, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 7},
            {8, 2, 0, 0, 0, 0, 6, 0, 3}};

        answerSudoku = new int[][]{
            {9, 6, 2, 4, 5, 1, 3, 7, 8},
            {3, 7, 4, 9, 8, 2, 5, 6, 1},
            {1, 8, 5, 7, 3, 6, 4, 2, 9},
            {4, 9, 6, 1, 7, 5, 8, 3, 2},
            {2, 1, 8, 3, 6, 9, 7, 4, 5},
            {7, 5, 3, 2, 4, 8, 1, 9, 6},
            {5, 3, 1, 6, 2, 7, 9, 8, 4},
            {6, 4, 9, 8, 1, 3, 2, 5, 7},
            {8, 2, 7, 5, 9, 4, 6, 1, 3}};

        sudoku = new Sudoku("medium", 0, "");
        user.setSudokus(sudoku);
        ds = new DisplaySudoku(userSudoku, answerSudoku, sudoku, user);
    }

    public void hard(User user) {
        userSudoku = new int[][]{
            {7, 4, 3, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 0, 0, 0, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {1, 7, 9, 0, 0, 0, 3, 0, 0},
            {3, 0, 4, 0, 0, 0, 0, 1, 0}};

        answerSudoku = new int[][]{
            {7, 4, 3, 1, 6, 2, 8, 9, 5},
            {6, 5, 8, 4, 7, 9, 2, 3, 1},
            {2, 9, 1, 5, 3, 8, 4, 6, 7},
            {8, 1, 5, 7, 2, 6, 9, 4, 3},
            {9, 6, 2, 3, 4, 5, 1, 7, 8},
            {4, 3, 7, 8, 9, 1, 6, 5, 2},
            {5, 8, 6, 9, 1, 3, 7, 2, 4},
            {1, 7, 9, 2, 5, 4, 3, 8, 6},
            {3, 2, 4, 6, 8, 7, 5, 1, 9}};

        sudoku = new Sudoku("hard", 0, "");
        user.setSudokus(sudoku);
        ds = new DisplaySudoku(userSudoku, answerSudoku, sudoku, user);
    }

}
