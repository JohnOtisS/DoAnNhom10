package com.app.application.hospital_app.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.FragmentServiceBinding;
import com.app.application.hospital_app.model.Service;
import com.app.application.hospital_app.ui.adapter.ServiceAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends Fragment {

    private FragmentServiceBinding binding;
    private DatabaseDAO dao;
    private List<Service> list;
    private ServiceAdapter adapter;
    private long mId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentServiceBinding.inflate(getLayoutInflater());

        init();

        return binding.getRoot();
    }

    private void init() {
        mId = ShareUtils.getIDBnCurrent(requireActivity());
        dao = new DatabaseDAO(requireActivity());
        list = new ArrayList<>();
        list = dao.serviceDAO.getServices(mId);
        adapter = new ServiceAdapter(requireActivity(), list);
        adapter.setList(list);
        binding.rcv.setAdapter(adapter);
    }
}