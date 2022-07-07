package ch.bbcag.openworkout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.Date;

import ch.bbcag.openworkout.dal.ExerciseDao;
import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.dal.WorkoutDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.Workout;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private SetDao setDao;
    private ImageView imageView;
    private FloatingActionButton floatingButton;


    private ExerciseDao exerciseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();
        exerciseDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getExerciseDao();
        Exercise pullup = new Exercise(("Pull-Up"));
        exerciseDao.insert(pullup);
        setDao.insert(new Set(1, 100, 15, LocalDateTime.now().toString()));
        setDao.insert(new Set(1,105, 11, LocalDateTime.now().toString()));
        setDao.insert(new Set(pullup.getId(), 110, 8, LocalDateTime.now().toString()));
        setContentView(R.layout.activity_main);
        setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();;


        imageView = findViewById(R.id.stats_button);
        //imageView.setOnClickListener(this);


        floatingButton = (FloatingActionButton)findViewById(R.id.new_workout_button);


        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(intent);
            }
        });

        floatingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewWorkoutActivity.class);
                startActivity(intent);
                }
        });

    }
}