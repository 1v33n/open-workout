package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.SetAndExercise;

@Dao
public interface ExerciseDao {

    @Update
    void update(Exercise set);

    @Insert
    void insert(Exercise set);

    @Query("Delete from Exercise")
    void deleteAll();

    @Query("SELECT * FROM `Exercise` WHERE name = :name")
    Exercise getExerciseByName(String name);
}
