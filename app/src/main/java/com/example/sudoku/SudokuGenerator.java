package com.example.sudoku;

import java.util.Random;

public class SudokuGenerator {
    public enum DifficultyLevel {
        EASY(30), MEDIUM(40), HARD(50);
        private final int numCellsToRemove;
        DifficultyLevel(int numCellsToRemove) {
            this.numCellsToRemove = numCellsToRemove;
        }
        public int getNumCellsToRemove() {
            return numCellsToRemove;
        }
    }
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int NO_VALUE = 0;
    private int[][] board;
    public SudokuGenerator() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
    }
    public int[][] generateGrid(DifficultyLevel difficulty) {
        int numCellsToRemove = difficulty.getNumCellsToRemove();
        solveBoard();
        int count = 0;
        while (count < numCellsToRemove) {
            int row = new Random().nextInt(BOARD_SIZE);
            int col = new Random().nextInt(BOARD_SIZE);
            if (board[row][col] != NO_VALUE) {
                board[row][col] = NO_VALUE;
                count++;
            }
        }
        return board;
    }
    private boolean solveBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == NO_VALUE) {
                    for (int value = 1; value <= BOARD_SIZE; value++) {
                        if (isValid(row, col, value)) {
                            board[row][col] = value;
                            if (solveBoard()) {
                                return true;
                            } else {
                                board[row][col] = NO_VALUE;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(int row, int col, int value) {
        int rowOffset = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int colOffset = (col / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == value || board[i][col] == value ||
                    board[rowOffset + (i % SUBSECTION_SIZE)][colOffset + (i / SUBSECTION_SIZE)] == value) {
                return false;
            }
        }
        return true;
    }
}
