package com.app.application.hospital_app.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.app.application.hospital_app.common.Key;
import com.app.application.hospital_app.database.DbHelper;
import com.app.application.hospital_app.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private DbHelper dbHelper;

    public EventDAO(Context context) {
        this.dbHelper = new DbHelper(context, Key.database_name, null, 1);
    }

    public void createTable() {
        String sql = Key.query_create_table_event;
        dbHelper.queryData(sql);
    }

    public void insertTable() {
        List<String> list = new ArrayList<>();

        list.add("insert into event (id_service, id_bn, time) values (1, 1, '01/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (2, 1, '01/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (7, 2, '01/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (3, 2, '18/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (2, 2, '23/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (5, 2, '18/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (4, 2, '26/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (1, 3, '12/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (2, 3, '18/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (3, 3, '23/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (4, 3, '25/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (5, 3, '30/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (7, 4, '10/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (6, 4, '05/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (5, 5, '15/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (2, 5, '20/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (1, 6, '04/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (2, 6, '17/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (7, 6, '09/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (5, 7, '12/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (4, 7, '08/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (6, 7, '02/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (2, 8, '17/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (7, 8, '23/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (7, 9, '23/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (1, 9, '16/10/2023')");

        list.add("insert into event (id_service, id_bn, time) values (6, 10, '10/10/2023')");
        list.add("insert into event (id_service, id_bn, time) values (5, 10, '23/10/2023')");

        for (String s : list) {
            dbHelper.queryData(s);
        }
    }

    public List<Event> getEvent(String date) {
        String sql = "select event.id as id, service.service_name as service_name, patients.hoTen as hoten_bn, event.time as time " +
                "from event " +
                "join service on service.id = event.id_service " +
                "join patients on patients.id = event.id_bn " +
                "where event.time = '" + date + "'";
        Cursor cursor = dbHelper.getData(sql);
        List<Event> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String serviceName = cursor.getString(1);
            String bnName = cursor.getString(2);
            String time = cursor.getString(3);
            Event event = new Event(id, serviceName, bnName, time);
            list.add(event);
        }

        Log.d("duylt", list.size() + "");

        return list;
    }
}
