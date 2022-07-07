package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ch.bbcag.openworkout.model.Set;
import ch.bbcag.openworkout.model.Workout;

@Dao
public interface SetDao {

    @Query("SELECT s.setId, s.exerciseId, s.date, e.name, s.weight, s.reps " +
            "FROM `Set` AS s " +
            "JOIN Exercise AS e " +
            "ON s.exerciseId = e.exerciseId")
    List<Set> getAll();

    @Update
    void update(Set set);

    @Insert
    void insert(Set set);
}
