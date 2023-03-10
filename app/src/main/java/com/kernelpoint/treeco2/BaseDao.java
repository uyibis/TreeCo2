package com.kernelpoint.treeco2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BaseDao<T>{

    @Update
    public void updateAll(List<T> t);

    @Update
    public void updateItem(T t);

    @Delete
    public void deleteAll(List<T> t);

    @Delete
    public void deleteItem(T t);

    @Insert
    void insertAll(List<T> t);

    @Insert
    void insertItem(T t);


}
