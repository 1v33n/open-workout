package ch.bbcag.openworkout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import ch.bbcag.openworkout.dal.ExerciseDao;
import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;

public class NewWorkoutActivity extends AppCompatActivity {
    private ImageView imageViewHome; //
    private ImageView imageViewStatistics; //
    private ImageView addNewSet;
    private Button canelButton, saveButton;
    private EditText nameExercise, weightExercise, repsExercise;

    private Pattern exercise = Pattern.compile("^[A-Za-zÄÖÜäöüß -]{2,}$");
    private Pattern weight = Pattern.compile("^[0-9]+$");
    private Pattern reps = Pattern.compile("^[0-9]+$");


    private ExerciseDao exerciseDao;
    private SetDao setDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);


/*
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Open Workout");
        */



        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        //TextView name = view.findViewById(R.id.name);
        //name.setOnClickListener(new View.OnClickListener() {






        imageViewStatistics = findViewById(R.id.stats_button);
        canelButton = findViewById(R.id.canel_button);
        saveButton = findViewById(R.id.save_button);
        nameExercise = findViewById(R.id.exercise_name);
        weightExercise = findViewById(R.id.exercise_weight);
        repsExercise = findViewById(R.id.exercise_reps);




        imageViewStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(intent);
            }
        });

        canelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid(nameExercise.getText().toString(), exercise) && isValid(weightExercise.getText().toString(), weight) && isValid(repsExercise.getText().toString(), reps)){
                    setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();
                    exerciseDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getExerciseDao();

                    Exercise newExercise = new Exercise(nameExercise.getText().toString());
                    exerciseDao.insert(newExercise);
                    newExercise = exerciseDao.getExerciseByName(newExercise.getName());

                    setDao.insert(new Set(newExercise.getId(),
                            Integer.parseInt(weightExercise.getText().toString()),
                            Integer.parseInt(repsExercise.getText().toString()),
                            LocalDateTime.now().toString()
                            ));
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    //Dialogfenster
                    generateAlertDialog();
                }
            }
        });


        EditText nameError = (EditText)findViewById(R.id.exercise_name);
        if(nameError.getText().toString().length() == 0 )
            nameError.setError("Exercise is required!");
        else {
            nameError.setError(null);
            // do async task
        }
        EditText repsError = (EditText)findViewById(R.id.exercise_reps);
        if(repsError.getText().toString().length() == 0 )
            repsError.setError("Reps is required!");
        else {
            repsError.setError(null);
            // do async task
        }

        EditText weightError = (EditText)findViewById(R.id.exercise_weight);
        if(weightError.getText().toString().length() == 0 )
            weightError.setError("Weight is required!");
        else {
            weightError.setError(null);
            // do async task
        }



    }

    public boolean isValid(String input, Pattern regex) {
        return regex.matcher(input).matches();
    }



    private void generateAlertDialog() {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Closes this activity
                //finish();
            }
        });
        dialogBuilder.setMessage("The fields aren't correctly filled, please correct!").setTitle("Input error");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }


}