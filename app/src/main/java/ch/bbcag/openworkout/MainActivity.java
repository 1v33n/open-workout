package ch.bbcag.openworkout;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.dal.WorkoutDao;
import ch.bbcag.openworkout.database.OpenWorkoutDatabase;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.Workout;


public class MainActivity extends AppCompatActivity {

    private SetDao setDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDao = OpenWorkoutDatabase.getInstance(getApplicationContext()).getSetDao();;
    }
}