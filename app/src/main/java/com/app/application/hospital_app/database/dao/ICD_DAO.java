package com.app.application.hospital_app.database.dao;

import android.content.Context;
import android.database.Cursor;

import com.app.application.hospital_app.common.Key;
import com.app.application.hospital_app.database.DbHelper;
import com.app.application.hospital_app.model.ICD;

import java.util.ArrayList;
import java.util.List;

public class ICD_DAO {
    private DbHelper dbHelper;

    public ICD_DAO(Context context) {
        this.dbHelper = new DbHelper(context, Key.database_name, null, 1);
    }

    public void createTable() {
        String sql = Key.query_create_table_icd;
        String sql2 = Key.query_create_table_icd_details;
        dbHelper.queryData(sql);
        dbHelper.queryData(sql2);
    }

    public void insertTable() {
        insertICD();
        insertICDDetails();
    }

    private void insertICD() {
        String sql = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Bệnh ung thư các loại', 'U ác của tim, trung thất và màng phổi', 'U ác của cơ quan hô hấp và trong lồng ngực')";
        String sql1 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Suy tủy xương', 'Suy tủy xương không đặc hiệu khác', 'Suy tuỷ xương và các bệnh thiếu máu khác')";
        String sql2 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Đái tháo đường type 1, type 2', 'Bệnh đái tháo đường phụ thuộc insuline', 'Đái tháo đường')";
        String sql3 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Ban xuất huyết giảm tiểu cầu không rõ nguyên nhân (Hội chứng Evans)', 'Ban xuất huyết giảm tiểu cầu vô căn', 'Các rối loạn đông máu, ban xuất huyết và tình trạng xuất huyết khác')";
        String sql4 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Xuất huyết não', 'Xuất huyết nội sọ', 'Bệnh mạch máu não')";
        String sql5 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Đột quỵ không rõ nhồi máu não hay xuất huyết não', 'Đột quị, không xác định do xuất huyết hay nhồi máu (Tai biến mạch máu não)', 'Bệnh mạch máu não')";
        String sql6 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Động kinh', 'Động kinh', 'Bệnh chu kỳ và kịch phát')";
        String sql7 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Bệnh Parkinson', 'Bệnh Parkinson', 'Hội chứng ngoại tháp và rối loạn vận động')";
        String sql8 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Bệnh Alzheimer', 'Bệnh Alzheimer', 'Bệnh thoái hoá khác của hệ thần kinh')";
        String sql9 = "insert into icd (description, ten_benh, nhom_benh) values ('Tên theo Thông tư số 34/2013/TT-BYT: Điếc đột ngột không rõ nguyền nhân', 'Điếc đột ngột không rõ nguyên do', 'Bệnh khác của tai')";

        dbHelper.queryData(sql);
        dbHelper.queryData(sql1);
        dbHelper.queryData(sql2);
        dbHelper.queryData(sql3);
        dbHelper.queryData(sql4);
        dbHelper.queryData(sql5);
        dbHelper.queryData(sql6);
        dbHelper.queryData(sql7);
        dbHelper.queryData(sql8);
        dbHelper.queryData(sql9);
    }

    private void insertICDDetails() {
        List<String> list = new ArrayList<>();

        list.add("insert into icd_details (id_icd, id_bn) values (3, 1)");
        list.add("insert into icd_details (id_icd, id_bn) values (5, 1)");
        list.add("insert into icd_details (id_icd, id_bn) values (7, 1)");

        list.add("insert into icd_details (id_icd, id_bn) values (1, 2)");

        list.add("insert into icd_details (id_icd, id_bn) values (2, 3)");
        list.add("insert into icd_details (id_icd, id_bn) values (4, 3)");
        list.add("insert into icd_details (id_icd, id_bn) values (6, 3)");
        list.add("insert into icd_details (id_icd, id_bn) values (8, 3)");
        list.add("insert into icd_details (id_icd, id_bn) values (10, 3)");

        list.add("insert into icd_details (id_icd, id_bn) values (1, 4)");
        list.add("insert into icd_details (id_icd, id_bn) values (3, 4)");
        list.add("insert into icd_details (id_icd, id_bn) values (5, 4)");
        list.add("insert into icd_details (id_icd, id_bn) values (7, 4)");
        list.add("insert into icd_details (id_icd, id_bn) values (9, 4)");

        list.add("insert into icd_details (id_icd, id_bn) values (3, 5)");
        list.add("insert into icd_details (id_icd, id_bn) values (4, 5)");
        list.add("insert into icd_details (id_icd, id_bn) values (6, 5)");

        list.add("insert into icd_details (id_icd, id_bn) values (2, 6)");
        list.add("insert into icd_details (id_icd, id_bn) values (3, 6)");
        list.add("insert into icd_details (id_icd, id_bn) values (4, 6)");

        list.add("insert into icd_details (id_icd, id_bn) values (10, 7)");
        list.add("insert into icd_details (id_icd, id_bn) values (9, 7)");

        for (String s : list) {
            dbHelper.queryData(s);
        }
    }

    public List<ICD> getList(long id) {
        String sql = "select * from icd inner join icd_details on icd_details.id_icd = icd.id where icd_details.id_bn = " + id;
        Cursor cursor = dbHelper.getData(sql);
        List<ICD> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            long idRes = cursor.getLong(0);
            String description = cursor.getString(1);
            String tenBenh = cursor.getString(2);
            String nhomBenh = cursor.getString(3);
            ICD icd = new ICD(idRes, description, tenBenh, nhomBenh);
            list.add(icd);
        }

        return list;
    }

    public List<ICD> getAllList() {
        String sql = "select * from icd ";
        Cursor cursor = dbHelper.getData(sql);
        List<ICD> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            long idRes = cursor.getLong(0);
            String description = cursor.getString(1);
            String tenBenh = cursor.getString(2);
            String nhomBenh = cursor.getString(3);
            ICD icd = new ICD(idRes, description, tenBenh, nhomBenh);
            list.add(icd);
        }

        return list;
    }

    public void insert(String des, String nhom, String ten) {
        String sql = "insert into icd (description, ten_benh, nhom_benh) values ('"+des+"', '"+nhom+"', '"+ten+"')";
        dbHelper.queryData(sql);
    }
}
