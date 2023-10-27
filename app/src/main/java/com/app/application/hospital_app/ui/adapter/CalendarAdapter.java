package com.app.application.hospital_app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.model.Calendar;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

    private ArrayList<Calendar> daysOfMonth;
    private OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<Calendar> daysOfMonth, OnItemListener onItemListener) {
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
    }

    public void setDaysOfMonth(ArrayList<Calendar> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        if (daysOfMonth.get(position).getI() != 0) {
            holder.dayOfMonth.setText(daysOfMonth.get(position).getI() + "");
        } else {
            holder.dayOfMonth.setText("");
        }
        if (daysOfMonth.get(position).isSelected()) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }

        holder.layoutContainer.setOnClickListener(view -> onItemListener.onItemClick(position, daysOfMonth.get(position)));
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }

    public interface OnItemListener {
        void onItemClick(int position, Calendar calendar);
    }

    class CalendarViewHolder extends RecyclerView.ViewHolder {
        public TextView dayOfMonth;
        private View view;
        public ConstraintLayout layoutContainer;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            dayOfMonth = itemView.findViewById(R.id.cellDayText);
            view = itemView.findViewById(R.id.dot);
            layoutContainer = itemView.findViewById(R.id.layoutContainer);
        }
    }
}
