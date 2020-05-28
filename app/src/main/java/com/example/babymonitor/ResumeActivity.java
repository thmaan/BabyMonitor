package com.example.babymonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ResumeActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    private ArrayList<Resume> resumes;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Integer countDormiu;
    private TextView trocado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        countDormiu = 0;
        final Resume r = new Resume();
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getCountMamou().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                countDormiu = integer;
                Log.d("TAG", "get count dormiu " + integer);
            }
        });
        ArrayList<Resume> resumes = new ArrayList<>();
        resumes.add(new Resume(countDormiu,countDormiu,countDormiu,countDormiu));
        resumes.add(r);
        trocado = findViewById(R.id.text_view_trocado);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ResumeAdapter(resumes);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
