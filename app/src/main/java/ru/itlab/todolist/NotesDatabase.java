package ru.itlab.todolist;


import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    private static final String DB_NAME = "notes.db";
    private static NotesDatabase instance;
    public static NotesDatabase getInstance(Application application){
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    NotesDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract NotesDAO notesDAO();
}
