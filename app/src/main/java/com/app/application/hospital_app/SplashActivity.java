package com.app.application.hospital_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.app.application.hospital_app.common.ShareUtils;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.ui.activity.auth.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private DatabaseDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        checkFirstInstall();

        new Handler(Looper.getMainLooper())
                .postDelayed(() -> startActivity(new Intent(SplashActivity.this, LoginActivity.class)), 3000);
    }

    private void init() {
        dao = new DatabaseDAO(this);
    }

    private void checkFirstInstall() {
        if (ShareUtils.getFirstInstall(this)) { // first install
            ShareUtils.saveFirstInstall(this);
            createTable();
        }
    }

    private void createTable() {
        dao.userDAO.createTable();
        dao.userDAO.insertDefaultAccount();
        dao.bnDAO.createTable();
        dao.bnDAO.insertBn();
        dao.serviceDAO.createTable();
        dao.serviceDAO.insertData();
        dao.icdDao.createTable();
        dao.icdDao.insertTable();
        dao.eventDAO.createTable();
        dao.eventDAO.insertTable();
    }
}