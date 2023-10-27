package com.app.application.hospital_app.database.dao;

import android.content.Context;
import android.database.Cursor;

import com.app.application.hospital_app.common.Key;
import com.app.application.hospital_app.common.ListObject;
import com.app.application.hospital_app.database.DbHelper;
import com.app.application.hospital_app.model.BN;

import java.util.ArrayList;
import java.util.List;

public class BnDAO {
    private DbHelper dbHelper;

    public BnDAO(Context context) {
        this.dbHelper = new DbHelper(context, Key.database_name, null, 1);
    }

    public void createTable() {
        String sql = Key.CREATE_PATIENT_TABLE;
        dbHelper.queryData(sql);
    }

    public void insertBn() {
        for (int i = 0; i < ListObject.getBns().size(); i++) {
            BN bn = ListObject.getBns().get(i);
            String insertQuery = "INSERT INTO " + Key.TABLE_PATIENT + " (" +
                    Key.COLUMN_NUMBER_BHYT + ", " +
                    Key.COLUMN_THOI_HAN_BHYT + ", " +
                    Key.COLUMN_NOI_DANG_KY + ", " +
                    Key.COLUMN_HO_TEN + ", " +
                    Key.COLUMN_DOB + ", " +
                    Key.COLUMN_GENDER + ", address) " +
                    "VALUES ('"+bn.getNumberBHYT()+"', '"+bn.getThoiHanBHYT()+"', '"+bn.getNoiDangKy()+"', '"+bn.getHoTen()+"', '"+bn.getDob()+"', "+bn.getGender()+", '"+bn.getAddress()+"')";
            dbHelper.queryData(insertQuery);
        }
    }

    public List<BN> getBn() {
        List<BN> list = new ArrayList<>();

        String sql = "SELECT * FROM " + Key.TABLE_PATIENT;
        Cursor cursor = dbHelper.getData(sql);
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String numberBHYT = cursor.getString(1);
            String thoiHanDangKi = cursor.getString(2);
            String noiDangKi = cursor.getString(3);
            String hoTen = cursor.getString(4);
            String dob = cursor.getString(5);
            int gender = cursor.getInt(6);
            String address = cursor.getString(7);
            BN bn = new BN(id, numberBHYT, thoiHanDangKi, noiDangKi, hoTen, dob, gender, address);
            list.add(bn);
        }

        return list;
    }

    public void deleteBn(long id) {
        String sql = "delete from patients where id = " + id;
        dbHelper.queryData(sql);
    }
}
