package com.app.application.hospital_app.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.ListObject;
import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.common.Utils;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.FragmentListBinding;
import com.app.application.hospital_app.model.BN;
import com.app.application.hospital_app.ui.activity.home.DetailsActivity;
import com.app.application.hospital_app.ui.adapter.BenhNhanAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private List<BN> list;
    private BenhNhanAdapter adapter;
    private DatabaseDAO dao;
    private FragmentListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(getLayoutInflater());

        init();

        return binding.getRoot();
    }

    private void init() {
        list = new ArrayList<>();
        adapter = new BenhNhanAdapter(requireActivity(), list, new BenhNhanAdapter.OnClickBn() {
            @Override
            public void showDetails(BN bn, int index) {
                ShareUtils.saveIDBnCurrent(requireActivity(), bn.getId());
                Intent intent = new Intent(requireActivity(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", bn);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void update(BN bn, int index) {
                new AlertDialog.Builder(requireActivity())
                        .setTitle("Xác nhận xóa")
                        .setMessage("Bạn có muốn xóa bệnh nhân " + bn.getHoTen() + "?")
                        .setNegativeButton("Có", (dialog, which) -> {
                            dao.bnDAO.deleteBn(bn.getId());
                            loadData();
                        })
                        .setPositiveButton("Không", null)
                        .show();
            }
        });
        dao = new DatabaseDAO(requireActivity());
        loadData();
        binding.rcvBenhNhan.setAdapter(adapter);
    }

    private void loadData() {
        list = dao.bnDAO.getBn();
        adapter.setList(list);
    }
}