package com.example.babymonitor;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private LiveData<List<Note>> notesByDate;
    private LiveData<List<Note>> notesDormiu;
    private LiveData<List<Note>> notesAcordou;
    private LiveData<List<Note>> notesTrocou;
    private LiveData<List<Note>> notesMamou;
    private LiveData<Integer> countMamou;
    private LiveData<Integer> countTrocou;

    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
        notesByDate = noteDao.getAllByDate();
        notesDormiu = noteDao.getAllDormiu();
        notesAcordou = noteDao.getAllAcordou();
        notesTrocou = noteDao.getAllTrocou();
        notesMamou = noteDao.getAllMamou();
        countMamou = noteDao.getCountMamou();
        countTrocou = noteDao.getCountTrocou();
    }
    public void insert(Note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void update(Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public void delete(Note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }
    public void deleteAllNotes(){
        new DeleteAllNoteAsyncTask(noteDao).execute();
    }

    public LiveData<Integer> getCountTrocou() {
        return countTrocou;
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public LiveData<Integer> getCountMamou() {
        return countMamou;
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

    public LiveData<List<Note>> getNotesDormiu() {
        return notesDormiu;
    }

    public LiveData<List<Note>> getNotesByDate() {
        return notesByDate;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void>{
        private NoteDao noteDao;

        private DeleteAllNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
