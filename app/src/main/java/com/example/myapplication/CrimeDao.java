package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.UUID;

@Dao
public interface CrimeDao {
    @Insert
    void insertCrime(Crime crime);

    @Query("SELECT * FROM Crime")
    List<Crime> getAllCrimes();

    @Query("SELECT * FROM crime")
    List<Crime> getCrimes();

    @Query("SELECT * FROM crime WHERE id = :id")
    Crime getCrime(UUID id);
}
