package com.example.babymonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ResumeHolder> {
    private ArrayList<Resume> resumes;
     @NonNull
    @Override
    public ResumeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resume_item, parent, false);
        return new ResumeAdapter.ResumeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeHolder holder, int position) {
        Resume currentResume = resumes.get(position);
        holder.resumeText.setText(currentResume.getResume());
        holder.dateText.setText(String.valueOf(currentResume.getDate()));
    }

    public ResumeAdapter(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }

    @Override
    public int getItemCount() {
         if(resumes != null)
             return resumes.size();
         else return 0;
    }


   public static class ResumeHolder extends RecyclerView.ViewHolder{
        private TextView resumeText;
        private TextView dateText;

        public ResumeHolder(@NonNull View itemView) {
            super(itemView);
            resumeText = itemView.findViewById(R.id.text_view_trocado);
            dateText = itemView.findViewById(R.id.text_view_date);

        }
    }

}
