package com.example.dice.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.dice.models.History;

@Database(entities = History.class, version = 1)
public abstract class HistoryDB extends RoomDatabase {

    public static final String DATABASE_NAME = "history_db";

    private static HistoryDB instance;
    public static HistoryDB getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    HistoryDB.class,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract HistoryDao getHistoryDao();
}
