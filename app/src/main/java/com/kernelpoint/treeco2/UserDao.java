package com.kernelpoint.treeco2;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;


@androidx.room.Dao
public interface UserDao extends BaseDao<User>{
    @Query("SELECT * FROM User")
    List<User> getDetails();
}
