import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup difficultyRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultyRadioGroup = findViewById(R.id.radio_group_difficulty);
        Button startButton = findViewById(R.id.button_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int difficulty = getDifficulty();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("difficulty", difficulty);
                startActivity(intent);
            }
        });
    }

    private int getDifficulty() {
        int checkedRadioButtonId = difficultyRadioGroup.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.radio_easy:
                return 1;
            case R.id.radio_medium:
                return 2;
            case R.id.radio_hard:
                return 3;
            default:
                return 1;
        }
    }
}
