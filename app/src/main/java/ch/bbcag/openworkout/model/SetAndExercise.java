package ch.bbcag.openworkout.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;

public class SetAndExercise {
    @Embedded
    public Exercise exercise;
    @Relation(
            parentColumn = "exerciseId",
            entityColumn = "exerciseId"
    )
    public List<Set> sets;

    @Override
    public String toString() {
        return "Date : "+(sets.get(0).getDate()).substring(0, 10) +
                "\n" + exercise.getName() +
                "\n Reps: \t"+ sets.get(0).getWeight() +
                "\n Weight: \t"+ sets.get(0).getReps();

    }
}
