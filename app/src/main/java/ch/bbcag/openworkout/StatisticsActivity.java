package ch.bbcag.openworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.view.View.OnClickListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ch.bbcag.openworkout.dal.ExerciseDao;
import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.SetAndExercise;
import im.dacer.androidcharts.BarView;
import im.dacer.androidcharts.LineView;

public class StatisticsActivity extends AppCompatActivity implements OnClickListener{

    private ImageView imageView;
    private ExerciseDao exerciseDao;
    private SetDao setDao;
    private Exercise exerciseToShow;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        imageView = findViewById(R.id.home_button);
        imageView.setOnClickListener(this);
        saveButton = findViewById(R.id.save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameExerciseField = findViewById(R.id.exercise_name_stat);
                String nameInput = nameExerciseField.getText().toString();
                if(nameInput !=""){
                    setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();
                    exerciseDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getExerciseDao();
                    SetAndExercise setsOfExercise = setDao.getSetsByExercises(nameInput) != null ? setDao.getSetsByExercises(nameInput)  : null;
                    if(setsOfExercise != null){
                        ArrayList<String> strList = new ArrayList<String>();
                        ArrayList<ArrayList<Integer>>  dataLists = new ArrayList<>();
                        ArrayList<Integer>  dataList = new ArrayList<>();

                        for (Set set : setsOfExercise.sets) {
                            dataList.add(set.getWeight());
                        }
                        dataLists.add(dataList);
                        for (Set set : setsOfExercise.sets) {
                            strList.add(set.getDate().substring(0,10));
                        }
                        LineView lineView = (LineView)findViewById(R.id.line_view);
                        lineView.setBottomTextList(strList);
                        lineView.setColorArray(new int[]{Color.BLACK,Color.GREEN,Color.GRAY,Color.CYAN});
                        lineView.setDataList(dataLists);
                    }
                }
            }
        });
    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        //setContentView(R.layout.avtivity_next);
    }

}