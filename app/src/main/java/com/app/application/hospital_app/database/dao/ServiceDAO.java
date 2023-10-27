package com.app.application.hospital_app.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.app.application.hospital_app.common.Key;
import com.app.application.hospital_app.database.DbHelper;
import com.app.application.hospital_app.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    private DbHelper dbHelper;

    public ServiceDAO(Context context) {
        this.dbHelper = new DbHelper(context, Key.database_name, null, 1);
    }

    public void createTable() {
        String sql1 = Key.query_create_table_service;
        String sql2 = Key.query_create_table_service_detail;
        dbHelper.queryData(sql1);
        dbHelper.queryData(sql2);
    }

    public void insertData() {
        insertTableService();
        insertTableServiceDetails();
    }

    private void insertTableService() {
        String sql1 = "insert into service (service_name) values ('KHU KHÁM VIP')";
        String sql2 = "insert into service (service_name) values ('KHÁM, TẦM SOÁT & ĐIỀU TRỊ BỆNH LÝ MẠCH MÁU')";
        String sql3 = "insert into service (service_name) values ('KHÁM, TẦM SOÁT & ĐIỀU TRỊ, BỆNH TIM BẨM SINH')";
        String sql4 = "insert into service (service_name) values ('DỊCH VỤ KHÁM, ĐIỀU TRỊ BỆNH TIM MẠCH CHO NGƯỜI LỚN')";
        String sql5 = "insert into service (service_name) values ('CÁC DỊCH VỤ CỦA ĐƠN VỊ HẬU MÔN – TRỰC TRÀNG')";
        String sql6= "insert into service (service_name) values ('DỊCH VỤ GIẢI PHẪU BỆNH & TẾ BÀO')";
        String sql7 = "insert into service (service_name) values ('LƯU TRỮ TẾ BÀO GỐC TỪ MÁU VÀ MÔ DÂY RỐN')";

        dbHelper.queryData(sql1);
        dbHelper.queryData(sql2);
        dbHelper.queryData(sql3);
        dbHelper.queryData(sql4);
        dbHelper.queryData(sql5);
        dbHelper.queryData(sql6);
        dbHelper.queryData(sql7);
    }

    private void insertTableServiceDetails() {
        List<String> list = new ArrayList<>();
        list.add("insert into service_details (id_service, id_bn) values(7, 1)");
        list.add("insert into service_details (id_service, id_bn) values(3, 1)");
        list.add("insert into service_details (id_service, id_bn) values(2, 1)");
        list.add("insert into service_details (id_service, id_bn) values(5, 1)");
        list.add("insert into service_details (id_service, id_bn) values(1, 1)");
        list.add("insert into service_details (id_service, id_bn) values(6, 1)");

        list.add("insert into service_details (id_service, id_bn) values(7, 2)");
        list.add("insert into service_details (id_service, id_bn) values(2, 2)");
        list.add("insert into service_details (id_service, id_bn) values(6, 2)");

        list.add("insert into service_details (id_service, id_bn) values(6, 3)");
        list.add("insert into service_details (id_service, id_bn) values(3, 3)");
        list.add("insert into service_details (id_service, id_bn) values(0, 3)");
        list.add("insert into service_details (id_service, id_bn) values(2, 3)");

        list.add("insert into service_details (id_service, id_bn) values(5, 4)");

        list.add("insert into service_details (id_service, id_bn) values(1, 5)");
        list.add("insert into service_details (id_service, id_bn) values(2, 5)");
        list.add("insert into service_details (id_service, id_bn) values(3, 5)");

        list.add("insert into service_details (id_service, id_bn) values(3, 6)");
        list.add("insert into service_details (id_service, id_bn) values(5, 6)");

        for (String s : list) {
            dbHelper.queryData(s);
        }
    }

    public List<Service> getServices(long id) {
        String sql = "SELECT * FROM service " +
                "JOIN service_details ON service.id = service_details.id_service " +
                "join patients on patients.id = service_details.id_bn " +
                "WHERE service_details.id_bn = " + id;
        List<Service> list = new ArrayList<>();
        Cursor cursor = dbHelper.getData(sql);
        while (cursor.moveToNext()) {
            long idRes = cursor.getLong(0);
            String name = cursor.getString(1);
            Service service = new Service(idRes, name);
            list.add(service);
        }

        return list;
    }

    public List<Service> getAllServices() {
        String sql = "SELECT * FROM service";
        List<Service> list = new ArrayList<>();
        Cursor cursor = dbHelper.getData(sql);
        while (cursor.moveToNext()) {
            long idRes = cursor.getLong(0);
            String name = cursor.getString(1);
            Service service = new Service(idRes, name);
            list.add(service);
        }

        return list;
    }

    public void insert(String name) {
        String sql = "insert into service (service_name) values ('"+name+"')";
        dbHelper.queryData(sql);
    }
}
