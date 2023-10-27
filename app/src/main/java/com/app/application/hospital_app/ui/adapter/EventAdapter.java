package com.app.application.hospital_app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    private Context context;
    private List<Event> list;

    public EventAdapter(Context context, List<Event> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<Event> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = list.get(position);

        holder.textTime.setText(event.getThoiGianKham());
        holder.textServiceName.setText(event.getTenDichVu());
        holder.textBnName.setText(event.getTenNguoiDat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView textServiceName, textBnName, textTime;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            textServiceName = itemView.findViewById(R.id.textServiceName);
            textBnName = itemView.findViewById(R.id.textBnName);
            textTime = itemView.findViewById(R.id.textTime);
        }
    }
}
