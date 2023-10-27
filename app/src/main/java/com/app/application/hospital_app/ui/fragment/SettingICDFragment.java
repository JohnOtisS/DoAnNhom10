package com.app.application.hospital_app.ui.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.Number;
import com.app.application.hospital_app.databinding.FragmentICDBinding;
import com.app.application.hospital_app.databinding.FragmentSettingICDBinding;
import com.app.application.hospital_app.ui.adapter.TabAdapter;

public class SettingICDFragment extends Fragment {

    private FragmentSettingICDBinding binding;
    private int flagScreen = Number.flagScreenService;
    private TabAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSettingICDBinding.inflate(getLayoutInflater());

        init();
        onClick();

        return binding.getRoot();
    }

    private void init() {
        adapter = new TabAdapter(requireActivity());
        binding.layoutContainer.setAdapter(adapter);
        binding.layoutContainer.setUserInputEnabled(false);
    }

    private void onClick() {
        binding.tab1.setOnClickListener(view -> replaceTab1());
        binding.tab2.setOnClickListener(view -> replaceTab2());
    }

    private void replaceTab1() {
        if (flagScreen != Number.flagScreenService) {
            flagScreen = Number.flagScreenService;
            binding.textTab1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.primary));
            binding.textTab2.setTextColor(ContextCompat.getColor(requireActivity(), R.color.black));
            binding.viewTab1.setVisibility(View.VISIBLE);
            binding.viewTab2.setVisibility(View.INVISIBLE);
            binding.layoutContainer.setCurrentItem(0);
        }
    }

    private void replaceTab2() {
        if (flagScreen != Number.flagScreenICD) {
            flagScreen = Number.flagScreenICD;
            binding.textTab1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.black));
            binding.textTab2.setTextColor(ContextCompat.getColor(requireActivity(), R.color.primary));
            binding.viewTab1.setVisibility(View.INVISIBLE);
            binding.viewTab2.setVisibility(View.VISIBLE);
            binding.layoutContainer.setCurrentItem(1);
        }
    }
}