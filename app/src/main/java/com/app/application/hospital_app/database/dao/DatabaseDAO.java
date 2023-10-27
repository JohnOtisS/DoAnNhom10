package com.app.application.hospital_app.database.dao;

import android.content.Context;

public class DatabaseDAO {
    public UserDAO userDAO;
    public BnDAO bnDAO;
    public ServiceDAO serviceDAO;
    public ICD_DAO icdDao;
    public EventDAO eventDAO;

    public DatabaseDAO(Context context) {
        this.userDAO = new UserDAO(context);
        this.bnDAO = new BnDAO(context);
        serviceDAO = new ServiceDAO(context);
        icdDao = new ICD_DAO(context);
        eventDAO = new EventDAO(context);
    }
}
