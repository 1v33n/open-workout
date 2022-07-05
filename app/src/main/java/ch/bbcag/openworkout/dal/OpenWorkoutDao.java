package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Workout;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.Exercise;

@Dao
public interface OpenWorkoutDao {
    @Query("SELECT * FROM Workout")
    List<Workout> getAll();

    @Query("SELECT * FROM Workout WHERE workoutId = :workoutId LIMIT 1")
    Workout getWorkoutById(int workoutId);

    @Update
    void update(Workout badi);

    @Insert
    void insert(Workout badi);
}
