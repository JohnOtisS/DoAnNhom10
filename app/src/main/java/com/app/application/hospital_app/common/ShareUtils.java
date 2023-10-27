package com.app.application.hospital_app.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.application.hospital_app.model.User;
import com.google.gson.Gson;

public class ShareUtils {
    public static boolean getFirstInstall(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);
        boolean isFirstInstall = sharedPreferences.getBoolean(Key.key_first_install_app, true);
        return isFirstInstall;
    }

    public static void saveFirstInstall(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Key.key_first_install_app, false);
        editor.apply();
    }

    public static void saveUserCurrent(Context context, User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Key.key_account_current, Utils.convertObjectToJSON(user));
        editor.apply();
    }

    public static User getAccountCurrent(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(Key.key_account_current, "");
        return Utils.convertJSONToObject(json);
    }

    public static void saveIDBnCurrent(Context context, long id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(Key.key_id_bn_current, id);
        editor.apply();
    }

    public static long getIDBnCurrent(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Key.share_name, Context.MODE_PRIVATE);

        return sharedPreferences.getLong(Key.key_id_bn_current, 0);
    }
}
