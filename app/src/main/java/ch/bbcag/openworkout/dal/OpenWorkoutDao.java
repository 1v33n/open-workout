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
    @Query("SELECT * FROM myBadi")
    List<Workout> getAll();

    @Query("SELECT COUNT(*) FROM myBadi WHERE isFavorite = 1")
    int getFavoritesCount();

    @Query("SELECT * FROM myBadi WHERE isFavorite = 1")
    List<Workout> getFavorites();

    @Query("SELECT * FROM myBadi WHERE badId = :badId LIMIT 1")
    Workout getBadiById(int badId);

    @Query("UPDATE myBadi SET isFavorite = 1 WHERE badId = :badId")
    void setFavorite(int badId);

    @Query("UPDATE myBadi SET isFavorite = 0 WHERE badId = :badId")
    void removeFavorite(int badId);

    @Update
    void update(Workout badi);

    @Insert
    void insert(Workout badi);
}
