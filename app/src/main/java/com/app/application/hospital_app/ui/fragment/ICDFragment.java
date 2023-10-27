package com.app.application.hospital_app.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.FragmentICDBinding;
import com.app.application.hospital_app.model.ICD;
import com.app.application.hospital_app.ui.adapter.ICDAdapter;

import java.util.ArrayList;
import java.util.List;

public class ICDFragment extends Fragment {

    private FragmentICDBinding binding;
    private ICDAdapter adapter;
    private List<ICD> list;
    private DatabaseDAO dao;
    private long idBnCurrent = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentICDBinding.inflate(getLayoutInflater());

        init();

        return binding.getRoot();
    }

    private void init() {
        idBnCurrent = ShareUtils.getIDBnCurrent(requireActivity());
        dao = new DatabaseDAO(requireActivity());
        list = new ArrayList<>();
        list = dao.icdDao.getList(idBnCurrent);
        adapter = new ICDAdapter(requireActivity(), list);
        binding.rcv.setAdapter(adapter);
    }
}