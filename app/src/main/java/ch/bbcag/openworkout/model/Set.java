package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Set")
public class Set {

    @PrimaryKey
    @ColumnInfo(name = "setId")
    private int id;

    @ColumnInfo(name = "exerciseId")
    private String exercise_id;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "reps")
    private int reps;


    @Ignore // Ignore -> not in database
    private List<Set> set;

    public Set() {
    }
}
