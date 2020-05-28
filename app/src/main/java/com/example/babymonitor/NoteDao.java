package com.example.babymonitor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY time")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT * FROM note_table ORDER BY time DESC")
    LiveData<List<Note>> getAllByDate();

    @Query("SELECT * FROM note_table WHERE eventType='Dormiu'")
    LiveData<List<Note>> getAllDormiu();

    @Query("SELECT * FROM note_table WHERE eventType='Mamou'")
    LiveData<List<Note>> getAllMamou();

    @Query("SELECT * FROM note_table WHERE eventType='Acordou'")
    LiveData<List<Note>> getAllAcordou();

    @Query("SELECT * FROM note_table WHERE eventType='Trocou'")
    LiveData<List<Note>> getAllTrocou();

    @Query("SELECT COUNT(*) FROM note_table WHERE eventType='Trocou'")
    LiveData<Integer> getCountTrocou();

    @Query("SELECT COUNT(*) FROM note_table WHERE eventType='Mamou'")
    LiveData<Integer> getCountMamou();
}
