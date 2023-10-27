package com.app.application.hospital_app.ui.activity.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.common.ListObject;
import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.ActivityLoginBinding;
import com.app.application.hospital_app.model.Major;
import com.app.application.hospital_app.model.User;
import com.app.application.hospital_app.ui.activity.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private List<Major> majors;
    private ActivityLoginBinding binding;
    private DatabaseDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        init();
        onClick();
    }

    private void init() {
        majors = new ArrayList<>();
        majors = ListObject.getMajors();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, majors);
        binding.spn.setAdapter(arrayAdapter);
        dao = new DatabaseDAO(this);
    }

    private void onClick() {
        binding.buttonLogin.setOnClickListener(view -> login());
    }

    private void login() {
        String email = binding.inputEmail.getText().toString().trim();
        String password = binding.inputPassword.getText().toString().trim();
        int indexMajor = binding.spn.getSelectedItemPosition();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Trường không được bỏ trống!", Toast.LENGTH_SHORT).show();
        } else {
            User user = dao.userDAO.handleLogin(email, password, indexMajor);
            if (user == null) {
                Toast.makeText(this, "Tài khoản không đúng!", Toast.LENGTH_SHORT).show();
            } else {
                ShareUtils.saveUserCurrent(this, user);
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
        }
    }
}