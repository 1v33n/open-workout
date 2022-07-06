package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Workout;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM Workout")
    List<Workout> getAll();

    @Query("SELECT * FROM Workout WHERE workoutId = :workoutId LIMIT 1")
    Workout getWorkoutById(int workoutId);


    @Update
    void update(Workout workout);

    @Insert
    void insert(Workout workout);
}
