package com.kernelpoint.treeco2;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    // creating a new variable for course repository.
    private DataRepo repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<User>> userLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepo(application);
       // userLiveData = repository.getAllCourses();
    }

    public void insert(User model) {
        repository.insert(model);
    }

    public void loadData(){
        userLiveData = repository.getAllCourses();
       // Log.i("userCount",userLiveData.getValue().get(0).getName());
    }



}
