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
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        int difficulty = intent.getIntExtra("difficulty", 1);
        gridValues = generateSudokuGrid(difficulty);

        GridView gridView = findViewById(R.id.grid_view);
        sudokuAdapter = new SudokuAdapter(this, gridValues);
        gridView.setAdapter(sudokuAdapter);
    }

    private int[][] generateSudokuGrid(int difficulty) {
        // TODO: Generate a solvable Sudoku grid based on the difficulty level
        // and return the grid as a 2D integer array
        return null;
    }
}
