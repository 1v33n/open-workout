package ch.bbcag.openworkout.model;

import androidx.room.Entity;

@Entity(primaryKeys = {"setId", "exerciseId"})
public class SetExerciseRef {
    public int setId;
    public int exerciseId;

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }
}
