package ch.bbcag.openworkout.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class WorkoutWithSetsAndExercises {
    @Embedded
    public Workout workout;
    @Relation(
            entity = Set.class,
            parentColumn = "workoutId",
            entityColumn = "setId"
    )
    public List<SetsWithExercise> sets;
}
