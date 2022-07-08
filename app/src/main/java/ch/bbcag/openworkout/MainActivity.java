package ch.bbcag.openworkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ch.bbcag.openworkout.dal.ExerciseDao;
import ch.bbcag.openworkout.model.SetAndExercise;
import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;

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
        //Testing DB
//        setDao.deleteAll();
//        exerciseDao.deleteAll();

//        Exercise pullup = new Exercise("Pull-Up");
//        Exercise pushup = new Exercise("Push-Up");
//        Exercise burpee = new Exercise("Burpee");
//        exerciseDao.insert(pullup);
//        exerciseDao.insert(pushup);
//        exerciseDao.insert(burpee);
//        pullup = exerciseDao.getExerciseByName(pullup.getName());
//        pushup = exerciseDao.getExerciseByName(pushup.getName());
//        burpee = exerciseDao.getExerciseByName(burpee.getName());
////        pullup = exerciseDao.getExerciseByName("Pull-Up");
//
//        setDao.insert(new Set(pullup.getId(), 100, 15, LocalDateTime.now().toString()));
//        setDao.insert(new Set(pushup.getId(),105, 11, LocalDateTime.now().toString()));
//        setDao.insert(new Set(burpee.getId(), 115, 8, LocalDateTime.now().toString()));
        setContentView(R.layout.activity_main);
        //



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
        addSetsToList();
    }

    private void addSetsToList(){
        setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();
        List<SetAndExercise> sets = setDao.getSetsWithExercises();
        ArrayAdapter<SetAndExercise> adapter = new ArrayAdapter<SetAndExercise>(this, android.R.layout.simple_list_item_1, sets);
        ListView listView = findViewById(R.id.sets_and_exercises);
        listView.setAdapter(adapter);
    }
}