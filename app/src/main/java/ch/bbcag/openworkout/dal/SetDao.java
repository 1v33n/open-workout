package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.SetAndExercise;

@Dao
public interface SetDao {
    @Transaction
    @Query("SELECT * FROM `Set` JOIN Exercise ON Exercise.exerciseId = `Set`.exerciseId")
    List<SetAndExercise> getSetsWithExercises();

    @Transaction
    @Query("SELECT * FROM `Set` " +
            "JOIN Exercise ON Exercise.exerciseId = `Set`.exerciseId " +
            "WHERE Exercise.name = :name LIMIT 1")
    SetAndExercise getSetsByExercises(String name);

    @Update
    void update(Set set);

    @Insert
    void insert(Set set);

    @Query("Delete from `Set`")
    void deleteAll();
}
