package com.kernelpoint.treeco2;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

// adding annotation for our database entities and db version.
@Database(entities = {User.class}, version = 1)
public abstract class AppDb extends RoomDatabase{
    public abstract UserDao userDao();

    private static AppDb INSTANCE;

    public static AppDb getDatabase(final Context context) {

        if (INSTANCE == null) {

            synchronized (AppDb.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                                    context, AppDb.class, "APPDB")
                            .fallbackToDestructiveMigration()
                            .build();

                }

            }

        }

        return INSTANCE;

    }

    // below line is to create a callback for our room database.
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // this method is called when database is created
            // and below line is to populate our data.
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    // we are creating an async task class to perform task in background.
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(AppDb instance) {
            UserDao dao = instance.userDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
