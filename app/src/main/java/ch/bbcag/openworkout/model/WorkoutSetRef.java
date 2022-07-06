package ch.bbcag.openworkout.model;

import androidx.room.Entity;


@Entity(primaryKeys = {"workoutId", "setId"})
public class WorkoutSetRef {
    private int workoutId;
    private int setId;

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }
}
