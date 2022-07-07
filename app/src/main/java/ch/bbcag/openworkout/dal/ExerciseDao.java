package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;

@Dao
public interface ExerciseDao {

    @Update
    void update(Exercise set);

    @Insert
    void insert(Exercise set);
}
