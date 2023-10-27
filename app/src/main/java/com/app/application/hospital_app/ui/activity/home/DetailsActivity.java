package com.app.application.hospital_app.ui.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.Number;
import com.app.application.hospital_app.databinding.ActivityDetailsBinding;
import com.app.application.hospital_app.model.BN;
import com.app.application.hospital_app.ui.fragment.ICDFragment;
import com.app.application.hospital_app.ui.fragment.ServiceFragment;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private int flagScreen = Number.flagScreenService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inside DetailsActivity onCreate() or any appropriate method
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            BN bn = (BN) bundle.getSerializable("object");
            if (bn != null) {
                showData(bn);
            }
        }

        replaceFragment(new ServiceFragment());
        onClick();
    }

    private void showData(final  BN bn) {
        binding.textUserName.setText(bn.getHoTen());
        binding.textDiaChi.setText("Địa chỉ: " + bn.getAddress());
        binding.textDOB.setText("Ngày sinh: " + bn.getDob());
        binding.textGioiTinh.setText("Giới tính: " + ((bn.getGender() == 0) ? "Nữ" : "Nam"));
        binding.textNoiDangKy.setText("Nơi đăng kí: " + bn.getNoiDangKy());
        binding.textHoTen.setText("Họ tên: " + bn.getHoTen());
        binding.textNumberBHYT.setText("Số BHYT: " + bn.getNumberBHYT());
        binding.textThoiHanBHYT.setText("Thời hạn: " + bn.getThoiHanBHYT());
    }

    private void onClick() {
        binding.iconBack.setOnClickListener(view -> finish());
        binding.layoutTab1.setOnClickListener(view -> replaceTab1());
        binding.layoutTab2.setOnClickListener(view -> replaceTab2());
    }

    private void replaceTab1() {
        if (flagScreen != Number.flagScreenService) {
            flagScreen = Number.flagScreenService;
            binding.textTab1.setTextColor(ContextCompat.getColor(this, R.color.primary));
            binding.textTab2.setTextColor(ContextCompat.getColor(this, R.color.black));
            binding.viewTab1.setVisibility(View.VISIBLE);
            binding.viewTab2.setVisibility(View.INVISIBLE);
            replaceFragment(new ServiceFragment());
        }
    }

    private void replaceTab2() {
        if (flagScreen != Number.flagScreenICD) {
            flagScreen = Number.flagScreenICD;
            binding.textTab1.setTextColor(ContextCompat.getColor(this, R.color.black));
            binding.textTab2.setTextColor(ContextCompat.getColor(this, R.color.primary));
            binding.viewTab1.setVisibility(View.INVISIBLE);
            binding.viewTab2.setVisibility(View.VISIBLE);
            replaceFragment(new ICDFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}