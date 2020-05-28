package com.example.babymonitor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allnotes;
    private LiveData<List<Note>> notesByDate;
    private LiveData<List<Note>> notesDormiu;
    private LiveData<List<Note>> notesAcordou;
    private LiveData<List<Note>> notesTrocou;
    private LiveData<List<Note>> notesMamou;
    private LiveData<Integer> countMamou;
    private LiveData<Integer> countTrocou;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allnotes = repository.getAllNotes();
        notesByDate = repository.getNotesByDate();
        notesDormiu = repository.getNotesDormiu();
        notesAcordou = repository.getNotesAcordou();
        notesTrocou = repository.getNotesTrocou();
        notesMamou = repository.getNotesMamou();
        countMamou = repository.getCountMamou();
        countTrocou = repository.getCountTrocou();
    }

    public void insert(Note note){
        repository.insert(note);
    }
    public void update(Note note){
        repository.update(note);
    }
    public void delete(Note note){
        repository.delete(note);
    }
    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<Integer> getCountTrocou() {
        return countTrocou;
    }

    public LiveData<Integer> getCountMamou() {
        return countMamou;
    }

    public LiveData<List<Note>> getAllnotes() {
        return allnotes;
    }

    public LiveData<List<Note>> getNotesAcordou() {
        return notesAcordou;
    }

    public LiveData<List<Note>> getNotesTrocou() {
        return notesTrocou;
    }

    public LiveData<List<Note>> getNotesMamou() {
        return notesMamou;
    }

    public LiveData<List<Note>> getNotesByDate() {
        return notesByDate;
    }

    public LiveData<List<Note>> getNotesDormiu() {
        return notesDormiu;
    }
}
