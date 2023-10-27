package com.app.application.hospital_app.common;

public class Key {
    //sql

    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MAJOR = "major";

    public static final String database_name = "Hospital_Manager.db";

    public static final String query_create_table_user =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_USER_NAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_MAJOR + " INTEGER)";

    public static final String query_insert_default_account =
            "INSERT INTO user (email, user_name, password, major) " +
            "VALUES ('default_account@gmail.com', 'Nguyen Van A', '123123', 1);";

    public static final String TABLE_PATIENT = "patients";

    // Tên các cột trong bảng bệnh nhân
    public static final String COLUMN_NUMBER_BHYT = "numberBHYT";
    public static final String COLUMN_THOI_HAN_BHYT = "thoiHanBHYT";
    public static final String COLUMN_NOI_DANG_KY = "noiDangKy";
    public static final String COLUMN_HO_TEN = "hoTen";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_GENDER = "gender";

    // Câu lệnh SQL để tạo bảng bệnh nhân
    public static final String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_PATIENT + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NUMBER_BHYT + " TEXT,"
            + COLUMN_THOI_HAN_BHYT + " TEXT,"
            + COLUMN_NOI_DANG_KY + " TEXT,"
            + COLUMN_HO_TEN + " TEXT,"
            + COLUMN_DOB + " TEXT,"
            + COLUMN_GENDER + " INTEGER, address text"
            + ")";

    public static final String query_create_table_service = "CREATE TABLE service (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    service_name TEXT\n" +
            ");";

    public static final String query_create_table_service_detail = "CREATE TABLE service_details (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    id_service INTEGER,\n" +
            "    id_bn INTEGER,\n" +
            "    FOREIGN KEY (id_service) REFERENCES service(id),\n" +
            "    FOREIGN KEY (id_bn) REFERENCES patients(id)\n" +
            ");\n";

    public static final String query_create_table_icd = "CREATE TABLE icd (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    description TEXT, ten_benh text, nhom_benh text" +
            ");\n";

    public static final String query_create_table_icd_details = "CREATE TABLE icd_details (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    id_icd INTEGER,\n" +
            "    id_bn INTEGER,\n" +
            "    FOREIGN KEY (id_icd) REFERENCES icd(id),\n" +
            "    FOREIGN KEY (id_bn) REFERENCES patients(id)\n" +
            ");\n";

    public static final String query_create_table_event =
            "create table event (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_service INTEGER, " +
                    "id_bn INTEGER, " +
                    "time text, " +
                    "FOREIGN KEY (id_bn) REFERENCES patients(id), " +
                    "FOREIGN KEY (id_service) REFERENCES service(id))";

    // share
    public static final String share_name = "share_name";
    public static final String key_first_install_app = "key_first_install_app";
    public static final String key_account_current = "key_account_current";
    public static final String key_id_bn_current = "key_id_bn_current";
}
