package com.app.application.hospital_app.common;

import com.app.application.hospital_app.model.User;
import com.google.gson.Gson;

public class Utils {
    public static String convertObjectToJSON(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        return json;
    }

    public static User convertJSONToObject(String json) {
        Gson gson = new Gson();

        return gson.fromJson(json, User.class);
    }
}
