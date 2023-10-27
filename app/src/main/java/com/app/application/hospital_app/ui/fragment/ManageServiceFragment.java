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
import com.app.application.hospital_app.databinding.FragmentManageServiceBinding;
import com.app.application.hospital_app.model.Service;
import com.app.application.hospital_app.ui.adapter.ServiceAdapter;

import java.util.ArrayList;
import java.util.List;

public class ManageServiceFragment extends Fragment {

    private FragmentManageServiceBinding binding;
    private DatabaseDAO dao;
    private List<Service> list;
    private ServiceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentManageServiceBinding.inflate(getLayoutInflater());

        init();
        onClick();

        return binding.getRoot();
    }

    private void init() {
        dao = new DatabaseDAO(requireContext());
        list = new ArrayList<>();
        list = dao.serviceDAO.getAllServices();
        adapter = new ServiceAdapter(requireActivity(), list);
        binding.rcv.setAdapter(adapter);
    }

    private void onClick() {
        binding.buttonAdd.setOnClickListener(view -> add());
    }

    private void add() {
        String name = binding.inputName.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(requireActivity(), "Trường không được để trống!", Toast.LENGTH_SHORT).show();
        } else {
            binding.inputName.getText().clear();
            Toast.makeText(requireActivity(), "Thêm dịch vụ thành công!", Toast.LENGTH_SHORT).show();
            dao.serviceDAO.insert(name);
            list = dao.serviceDAO.getAllServices();
            adapter.setList(list);
        }
    }
}