package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Workout;
import ch.bbcag.openworkout.model.WorkoutWithSetsAndExercises;

@Dao
public interface WorkoutDao {
    @Query("SELECT * FROM Workout")
    List<Workout> getAll();

    @Query("SELECT * FROM Workout WHERE workoutId = :workoutId LIMIT 1")
    Workout getWorkoutById(int workoutId);


/*    @Query("SELECT w.date, s.weight, s.reps, e.name FROM WorkoutWithSets as ws " +
            "JOIN Workout as w on ws.workoutId = w.id " +
            "JOIN Set as s on ws.setId = s.id" +
            "JOIN Exercise as e on s.exerciseId = e.id" +
            "WHERE workoutId = :workoutId ")
    Workout getSetsByWorkoutId(int workoutId, int setId);*/

    @Query("SELECT * FROM Workout")
    List<WorkoutWithSetsAndExercises> getWorkoutWithSetsAndExercises();

    @Update
    void update(Workout workout);

    @Insert
    void insert(Workout workout);
}
