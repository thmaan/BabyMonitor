package com.example.babymonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String EXTRA_ID = "com.example.babymonitor.EXTRA_EVENT_ID";
    public static final String EXTRA_EVENT_TYPE = "com.example.babymonitor.EXTRA_EVENT_TYPE";
    public static final String EXTRA_TIME = "com.example.babymonitor.EXTRA_TIME";
    public static final String EXTRA_DELETE_NOTE ="com.example.babymonitor.EXTRA_DELETE_NOTE";

    private Spinner spinnerEventType;
    private EditText time;
    private String textEventType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        time = findViewById(R.id.edit_text_time);
        spinnerEventType = findViewById(R.id.spinner_eventType);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerEventType.setAdapter(arrayAdapter);
        spinnerEventType.setOnItemSelectedListener(this);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
        }else{
            setTitle("Add Note");
        }
    }

    private void saveNote(){
        String mTime = time.getText().toString();
        if(mTime.trim().isEmpty()){
            Toast.makeText(this, "Insert a valid time!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_EVENT_TYPE, textEventType);
        data.putExtra(EXTRA_TIME, mTime);
        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if(id != -1){
            data.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK, data);
        finish();
    }
    private void deleteNote(){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DELETE_NOTE,true);
        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            case R.id.delete_note:
                deleteNote();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textEventType = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
