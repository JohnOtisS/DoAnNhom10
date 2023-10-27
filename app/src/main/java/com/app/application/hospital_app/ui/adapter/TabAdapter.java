package com.app.application.hospital_app.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.application.hospital_app.ui.fragment.ManageICDFragment;
import com.app.application.hospital_app.ui.fragment.ManageServiceFragment;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ManageServiceFragment();
        } else {
            return new ManageICDFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
