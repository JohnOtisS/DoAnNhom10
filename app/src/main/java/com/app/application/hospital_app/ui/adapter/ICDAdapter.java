package com.app.application.hospital_app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.model.ICD;

import java.util.List;

public class ICDAdapter extends RecyclerView.Adapter<ICDAdapter.ICDViewHolder>{

    private Context context;
    private List<ICD> list;

    public ICDAdapter(Context context, List<ICD> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<ICD> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ICDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ICDViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icd, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ICDViewHolder holder, int position) {
        ICD icd = list.get(position);

        holder.onBind(icd);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ICDViewHolder extends RecyclerView.ViewHolder {
        private TextView textName, textTenBenh, textNhomBenh, textDescription;

        public ICDViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textICDName);
            textTenBenh = itemView.findViewById(R.id.textTenBenh);
            textNhomBenh = itemView.findViewById(R.id.textNhomBenh);
            textDescription = itemView.findViewById(R.id.textDescription);
        }

        public void onBind(final ICD idc) {
            textName.setText(idc.getTenBenh());
            textTenBenh.setText("Tên bệnh: " + idc.getTenBenh());
            textNhomBenh.setText("Nhóm bệnh: " + idc.getNhomBenh());
            textDescription.setText("* Mô tả: " + idc.getDescription());
        }
    }
}
