package ch.bbcag.openworkout.dal;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import ch.bbcag.openworkout.model.Exercise;

public class ExerciseWithSet {
    @Embedded
    public Exercise exercise;
    @Relation(
            parentColumn = "exerciseId",
            entityColumn = "exerciseId"
    )
    public List<Exercise> exercises;
}
