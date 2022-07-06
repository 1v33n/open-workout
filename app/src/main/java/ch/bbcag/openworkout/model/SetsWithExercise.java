package ch.bbcag.openworkout.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class SetsWithExercise {
    @Embedded public Set set;
    @Relation(
            parentColumn = "setId",
            entityColumn = "exerciseId",
            associateBy = @Junction(SetExerciseRef.class)
    )
    public List<Exercise> exercises;
}
