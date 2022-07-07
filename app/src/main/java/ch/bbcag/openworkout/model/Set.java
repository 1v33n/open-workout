package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(tableName = "Set")
public class Set {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "setId")
    private int id;

    @ColumnInfo(name = "exerciseId")
    private int exerciseId;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "reps")
    private int reps;

    @ColumnInfo(name = "date")
    private String date;

    public Set() {
    }
    public Set(int exerciseId, int weight, int reps, String date) {
        this.exerciseId = exerciseId;
        this.weight = weight;
        this.reps = reps;
        this.date = date;
    }


}
