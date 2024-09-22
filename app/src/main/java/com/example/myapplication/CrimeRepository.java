package com.example.myapplication;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
import java.util.UUID;

// CrimeRepository.java
public class CrimeRepository {
    private CrimeDao crimeDao;

    // Singleton pattern for repository instance
    private static CrimeRepository INSTANCE;

    // Constructor
    private CrimeRepository(Context context) {
        CrimeDatabase database = Room.databaseBuilder(context.getApplicationContext(),
                CrimeDatabase.class, "crime-database").build();
        crimeDao = database.crimeDao();
    }

    public static CrimeRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CrimeRepository(context);
        }
        return INSTANCE;
    }

    // متد برای گرفتن همه جرم‌ها از دیتابیس
    public List<Crime> getCrimes() {
        return crimeDao.getCrimes();
    }

    // متد برای گرفتن یک جرم خاص با استفاده از UUID
    public Crime getCrime(UUID id) {
        return crimeDao.getCrime(id);
    }
}
