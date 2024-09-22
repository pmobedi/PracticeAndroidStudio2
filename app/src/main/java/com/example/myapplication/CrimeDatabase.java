package com.example.myapplication;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

@Database(entities = {Crime.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class CrimeDatabase extends RoomDatabase {
    public abstract CrimeDao crimeDao();

    private static CrimeDatabase INSTANCE;

    public static CrimeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CrimeDatabase.class, "crime_database")
                    .build();
        }
        return INSTANCE;
    }
}
