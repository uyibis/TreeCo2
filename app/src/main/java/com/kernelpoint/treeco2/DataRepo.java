package com.kernelpoint.treeco2;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class DataRepo {
    // below line is the create a variable
    // for dao and list for all courses.
    private UserDao dao;
    private LiveData<User> userLiveData;

    // creating a constructor for our variables
    // and passing the variables to it.
    public DataRepo(Application application) {

        AppDb database = AppDb.getDatabase(application);
        dao = database.userDao();
        Log.i(String.valueOf(R.string.userdb),"dataRepo was initialie");
        //userLiveData = dao.;
    }

    // creating a method to insert the data to our database.
    public void insert(User model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }



    // below method is to read all the courses.
    public LiveData<List<User>> getAllCourses() {
        new SelectUserAsyncTask(dao).execute();
//        Log.i(String.valueOf(R.string.userdb),"running get details");
//        List<User>  data=  dao.getDetails();
//        Log.i(String.valueOf(R.string.userdb),(new Gson()).toJson(data));
        return null;
    }

    // we are creating a async task method to insert new course.

    private static class InsertCourseAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao dao;

        private InsertCourseAsyncTask(UserDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            // dao.insert(model[0]);
            Log.i(String.valueOf(R.string.userdb), "inserting data");
            Gson json =new Gson();
            Log.i(String.valueOf(R.string.userdb),json.toJson(users[0]));
            dao.insertItem(users[0]);
            return null;
        }
    }
    private static class SelectUserAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao dao;

        private SelectUserAsyncTask(UserDao dao) {
            this.dao = dao;
        }



        @Override
        protected Void doInBackground(Void... voids) {
            Log.i(String.valueOf(R.string.userdb),"running get details");
            List<User>  data=  dao.getDetails();
          //  Log.i(String.valueOf(R.string.userdb),(new Gson()).toJson(data));

            return null;
        }
    }

}
