package ch.bbcag.openworkout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.dal.WorkoutDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.Workout;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    private SetDao setDao;
    private ImageView imageView; //
    private com.google.android.material.floatingactionbutton.FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();;


        imageView = findViewById(R.id.stats_button);

        floatingButton = findViewById(R.id.floating_action_button);


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


