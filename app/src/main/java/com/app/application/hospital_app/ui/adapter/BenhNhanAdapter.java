package com.app.application.hospital_app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.model.BN;

import java.util.List;

public class BenhNhanAdapter extends RecyclerView.Adapter<BenhNhanAdapter.BenhNhanViewHolder>{

    private Context context;
    private List<BN> list;
    private OnClickBn onClickBn;

    public BenhNhanAdapter(Context context, List<BN> list, OnClickBn onClickBn) {
        this.context = context;
        this.list = list;
        this.onClickBn = onClickBn;
    }

    public void setList(List<BN> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BenhNhanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BenhNhanViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_benh_nhan, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BenhNhanViewHolder holder, int position) {
        BN bn = list.get(position);

        holder.onBind(bn);

        holder.layoutManager.setOnClickListener(view -> onClickBn.showDetails(bn, position));
        holder.iconUpdate.setOnClickListener(view -> onClickBn.update(bn, position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BenhNhanViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layoutManager;
        TextView textName;
        ImageView iconUpdate;

        public BenhNhanViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);
        }

        private void init(View view) {
            layoutManager = view.findViewById(R.id.layoutContainer);
            textName = view.findViewById(R.id.textNameBenhNhan);
            iconUpdate = view.findViewById(R.id.iconUpdate);
        }

        public void onBind(final BN bn) {
            textName.setText(bn.getHoTen());
        }
    }

    public interface OnClickBn {
        void showDetails(BN bn, int index);
        void update(BN bn, int index);
    }
}
