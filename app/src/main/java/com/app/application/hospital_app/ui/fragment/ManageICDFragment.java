package com.app.application.hospital_app.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.FragmentManageICDBinding;
import com.app.application.hospital_app.model.ICD;
import com.app.application.hospital_app.ui.adapter.ICDAdapter;

import java.util.ArrayList;
import java.util.List;

public class ManageICDFragment extends Fragment {

    private FragmentManageICDBinding binding;
    private DatabaseDAO dao;
    private List<ICD> list;
    private ICDAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManageICDBinding.inflate(getLayoutInflater());

        init();

        binding.buttonAdd.setOnClickListener(view -> add());

        return binding.getRoot();
    }

    private void init() {
        dao = new DatabaseDAO(requireActivity());
        list = new ArrayList<>();
        list = dao.icdDao.getAllList();
        adapter = new ICDAdapter(requireActivity(), list);
        binding.rcv.setAdapter(adapter);
    }

    private void add() {
        String des = binding.inputDes.getText().toString().trim();
        String tenBenh = binding.inputTenBenh.getText().toString().trim();
        String nhomBenh = binding.inputNhomBenh.getText().toString().trim();

        if (des.isEmpty() || tenBenh.isEmpty() || nhomBenh.isEmpty()) {
            Toast.makeText(requireActivity(), "Trường không được để trống!", Toast.LENGTH_SHORT).show();
        } else {
            binding.inputDes.getText().clear();
            binding.inputNhomBenh.getText().clear();
            binding.inputTenBenh.getText().clear();

            Toast.makeText(requireActivity(), "Thêm ICD thành công!", Toast.LENGTH_SHORT).show();

            dao.icdDao.insert(des, nhomBenh, tenBenh);

            list = dao.icdDao.getAllList();
            adapter.setList(list);
        }
    }
}