package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity
public class Crime {
    @PrimaryKey
    @NonNull
    private UUID id;
    private String title;
    private Date date;
    private boolean isSolved;

    // Default constructor for Room
    public Crime() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    // Constructor
    @Ignore // اضافه کردن این Annotation برای نادیده گرفتن این سازنده توسط Room
    public Crime(UUID id, String title, Date date, boolean isSolved) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.isSolved = isSolved;
    }



    // Getter and Setter for id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for isSolved
    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
