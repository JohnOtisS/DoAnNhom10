package com.app.application.hospital_app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.model.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>{

    private Context context;
    private List<Service> list;

    public ServiceAdapter(Context context, List<Service> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<Service> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServiceViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dich_vu_da_kham, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service service = list.get(position);

        holder.textServiceName.setText(service.getServiceName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        private TextView textServiceName;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            textServiceName = itemView.findViewById(R.id.textDichVuName);
        }
    }
}
