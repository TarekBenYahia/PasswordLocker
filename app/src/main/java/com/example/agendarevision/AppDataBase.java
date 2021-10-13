package com.example.agendarevision;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.agendarevision.DAO.ModelDao;
import com.example.agendarevision.Entite.Model;

@Database(entities = {Model.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract ModelDao userDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "recap_app_all_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
