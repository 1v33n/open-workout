package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Workout;
import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.WorkoutSetRef;
import ch.bbcag.openworkout.model.Exercise;

@Dao
public interface OpenWorkoutDao {
    @Query("SELECT * FROM Workout")
    List<Workout> getAll();

    @Query("SELECT * FROM Workout WHERE workoutId = :workoutId LIMIT 1")
    Workout getWorkoutById(int workoutId);


    @Query("SELECT  FROM Set WHERE workoutId = :workoutId LIMIT 1")
    Workout getSetsByWorkoutId(int workoutId, int setId);

    @Insert
    void insert(Set set);

    @Update
    void update(Workout workout);

    @Insert
    void insert(Workout workout);
}
