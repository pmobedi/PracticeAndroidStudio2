package com.example.myapplication;

import androidx.room.TypeConverter;

import java.util.Date;

public class CrimeTypeConverters {
    @TypeConverter
    public Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public Date toDate(Long millisSinceEpoch) {
        return millisSinceEpoch == null ? null : new Date(millisSinceEpoch);
    }
}
