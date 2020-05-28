package com.example.babymonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private NoteAdapter.OnItemClickedListener listener;
    private OnDeleteClickListener onDeleteClickListener;
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.textViewEventType.setText(currentNote.getEventType());
        holder.textViewTime.setText(currentNote.getTime());
        holder.textViewDate.setText(currentNote.getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }
    public Note getNoteAt(int position){
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewEventType;
        private TextView textViewTime;
        private TextView textViewDate;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewEventType = itemView.findViewById(R.id.text_view_eventType);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewDate = itemView.findViewById(R.id.text_view_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClicked(notes.get(position));
                    }
                }
            });

        }
    }
    public interface OnItemClickedListener{
        void onItemClicked(Note note);
    }
    public interface OnDeleteClickListener{
        void onDeleteClickListener(Note note);
    }
    public void setOnClickListener(OnItemClickedListener listener){
        this.listener = listener;
    }
    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener){
        this.onDeleteClickListener = onDeleteClickListener;
    }
}
