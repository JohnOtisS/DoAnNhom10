package com.app.application.hospital_app.database.dao;

import android.content.Context;
import android.database.Cursor;

import com.app.application.hospital_app.common.Key;
import com.app.application.hospital_app.database.DbHelper;
import com.app.application.hospital_app.model.User;

public class UserDAO {
    private DbHelper dbHelper;

    public UserDAO(Context context) {
        this.dbHelper = new DbHelper(context, Key.database_name, null, 1);
    }

    public void createTable() {
        String sql = Key.query_create_table_user;
        dbHelper.queryData(sql);
    }

    public void insertDefaultAccount() {
        String sql = Key.query_insert_default_account;
        dbHelper.queryData(sql);
    }

    public User handleLogin(String email, String password, int indexMajor) {
        User user = null;

        String sql = "SELECT * FROM user where email = '"+email+"' and password = '"+password+"' and major = " + indexMajor;
        Cursor cursor = dbHelper.getData(sql);
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String emailRes = cursor.getString(1);
            String userName = cursor.getString(2);
            String passwordRes = cursor.getString(3);
            int majorRes = cursor.getInt(4);
            user = new User(id, emailRes, passwordRes, userName);
        }

        return user;
    }
}
