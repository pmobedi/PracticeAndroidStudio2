package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder> {
    private List<Crime> crimeList;

    public CrimeAdapter(List<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    // متد برای به‌روزرسانی لیست داده‌ها
    public void setCrimeList(List<Crime> crimeList) {
        this.crimeList = crimeList;
        notifyDataSetChanged(); // به آداپتور اعلام می‌کند که داده‌ها تغییر کرده‌اند
    }

    @NonNull
    @Override
    public CrimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crime, parent, false);
        return new CrimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeViewHolder holder, int position) {
        Crime crime = crimeList.get(position);
        holder.titleTextView.setText(crime.getTitle());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        holder.dateTextView.setText(dateFormat.format(crime.getDate()));
    }

    @Override
    public int getItemCount() {
        return crimeList != null ? crimeList.size() : 0;
    }

    static class CrimeViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;

        public CrimeViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_view_title);
            dateTextView = itemView.findViewById(R.id.text_view_date);
        }
    }
}
