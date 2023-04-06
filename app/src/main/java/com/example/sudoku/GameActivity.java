package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

public class GameActivity extends Activity {

    private SudokuAdapter sudokuAdapter;
    private int[][] gridValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        Intent intent = getIntent();
        int difficulty = intent.getIntExtra("difficulty", 1);
        gridValues = generateSudokuGrid(difficulty);

        GridView gridView = findViewById(R.id.grid_view_sudoku);
        sudokuAdapter = new SudokuAdapter(this, gridValues);
        gridView.setAdapter(sudokuAdapter);
    }

    private int[][] generateSudokuGrid(int difficulty) {
        SudokuGenerator generator = new SudokuGenerator();
        int[][] puzzle = null;
        switch (difficulty) {
            case 1:
                puzzle = generator.generateGrid(SudokuGenerator.DifficultyLevel.EASY);
                break;
            case 2:
                puzzle = generator.generateGrid(SudokuGenerator.DifficultyLevel.MEDIUM);
                break;
            case 3:
                puzzle = generator.generateGrid(SudokuGenerator.DifficultyLevel.HARD);
                break;
        }
        return puzzle;
    }

}
