package ch.bbcag.openworkout.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Embedded;
import androidx.room.Relation;
import androidx.room.Junction;

import java.util.List;

public class WorkoutWithSets {
    @Embedded public Workout playlist;
    @Relation(
            parentColumn = "playlistId",
            entityColumn = "songId",
            associateBy = @Junction(WorkoutSetRef.class)
    )
    public List<Set> sets;
}
