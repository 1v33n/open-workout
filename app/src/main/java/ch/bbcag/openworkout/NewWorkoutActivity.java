package ch.bbcag.openworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NewWorkoutActivity extends AppCompatActivity {
    private ImageView imageViewHome; //
    private ImageView imageViewStatistics; //
    private ImageView addNewSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);


        imageViewHome = findViewById(R.id.home_button);
        imageViewStatistics = findViewById(R.id.stats_button);
        addNewSet = findViewById(R.id.newSet);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        imageViewStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                startActivity(intent);
            }
        });
/*
        addNewSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = new TextView(this);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setText("New TextView");

                RelativeLayout layout = (RelativeLayout)findViewByID(R.id.layout_id);
                layout.addView(textView);
            }
        });
        */


    }
}