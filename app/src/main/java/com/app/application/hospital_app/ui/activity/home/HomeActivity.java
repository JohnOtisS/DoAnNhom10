package com.app.application.hospital_app.ui.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.Number;
import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.databinding.ActivityHomeBinding;
import com.app.application.hospital_app.model.User;
import com.app.application.hospital_app.ui.fragment.CalendarFragment;
import com.app.application.hospital_app.ui.fragment.ListFragment;
import com.app.application.hospital_app.ui.fragment.SettingICDFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private User mUser;
    private int flagScreen = Number.flagScreenListBenhNhanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        showData();
        onClick();
    }

    private void init() {
        mUser = ShareUtils.getAccountCurrent(this);
        replaceFragment(new ListFragment());
    }

    private void showData() {
        binding.textUserName.setText(mUser.getUserName());
    }

    private void onClick() {
        binding.buttonCoCau.setOnClickListener(view -> coCau());
        binding.buttonList.setOnClickListener(view -> showList());
        binding.buttonCalendar.setOnClickListener(view -> showListCalendar());
    }

    private void coCau() {
        if (flagScreen != Number.flagScreenSettingICD) {
            flagScreen = Number.flagScreenSettingICD;
            replaceFragment(new SettingICDFragment());
        }
    }

    private void showList() {
        if (flagScreen != Number.flagScreenListBenhNhanh) {
            flagScreen = Number.flagScreenListBenhNhanh;
            replaceFragment(new ListFragment());
        }
    }

    private void showListCalendar() {
        if (flagScreen != Number.flagScreenCalendar) {
            flagScreen = Number.flagScreenCalendar;
            replaceFragment(new CalendarFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}