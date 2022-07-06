package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Set")
public class Set {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
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

    public List<Set> getSet() {
        return set;
    }

    public void setSet(List<Set> set) {
        this.set = set;
    }

    @PrimaryKey
    @ColumnInfo(name = "setId")
    private int id;

    @ColumnInfo(name = "exerciseId")
    private String exerciseId;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "reps")
    private int reps;


    @Ignore // Ignore -> not in database
    private List<Set> set;

    public Set() {
    }
}
