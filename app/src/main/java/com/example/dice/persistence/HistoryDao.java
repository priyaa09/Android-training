package com.example.dice.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dice.models.History;

import java.util.List;


@Dao
public interface HistoryDao {

    @Insert
    void insertHistory(History... histories);

    @Query("SELECT * FROM histories")
    List<History> getAllHistories();
//    LiveData<List<History>> getHistory();

//    @Query("SELECT * \n" +
//            "FROM    histories \n" +
//            "WHERE   id = (SELECT MAX(id)  FROM histories)")
//    History getHistory();

    @Query("select *from histories order by id DESC LIMIT 1,1")
    History getHistory();


}
