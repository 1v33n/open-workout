package ch.bbcag.openworkout.dal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import ch.bbcag.openworkout.model.Set;

@Dao
public interface SetDao {

    @Update
    void update(Set set);

    @Insert
    void insert(Set set);
}
