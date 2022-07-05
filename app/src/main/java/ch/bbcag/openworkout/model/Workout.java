package ch.bbcag.openworkout.model;

import androidx.room.*;

import java.util.List;

@Entity(tableName = "Workout")
public class Workout {
    @PrimaryKey
    @ColumnInfo(name = "workoutId")
    private int id;

    @ColumnInfo(name = "date")
    private String date;


    @Ignore // Ignore -> not in database
    private List<Set> set;

    public Workout() {
    }
}
