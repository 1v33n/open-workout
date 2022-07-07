package ch.bbcag.openworkout.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ch.bbcag.openworkout.dal.SetDao;
import ch.bbcag.openworkout.dal.ExerciseDao;
import ch.bbcag.openworkout.model.Exercise;
import ch.bbcag.openworkout.model.Set;

@Database(
        entities = { Set.class, Exercise.class},
        version = 5
)
public abstract class OpenWorkoutDatabase extends RoomDatabase {
    private static volatile OpenWorkoutDatabase INSTANCE;

    protected OpenWorkoutDatabase() {
    }

    /**
     * For simplicity reasons use allowMainThreadQueries().
     * This means the main thread where the ui runs gets blocked by database calls.
     * This is not the best way to do it!
     * <p>
     * Singleton pattern -> https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
     *
     * @param context Application context
     * @return Database instance
     */
    public static synchronized OpenWorkoutDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            OpenWorkoutDatabase.class, "OpenWorkout Database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract SetDao getSetDao();
    public abstract ExerciseDao getExerciseDao();
    }