package ch.bbcag.openworkout.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ch.bbcag.openworkout.dal.OpenWorkoutDao;
import ch.bbcag.openworkout.model.workout;

@Database(
        entities = {workout.class},
        version = 1
)
public abstract class BadiRoomDatabase extends RoomDatabase {
    private static volatile BadiRoomDatabase INSTANCE;

    protected BadiRoomDatabase() {
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
    public static synchronized BadiRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BadiRoomDatabase.class, "BadiDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract BadiRoomDao getBadiRoomDao();
}