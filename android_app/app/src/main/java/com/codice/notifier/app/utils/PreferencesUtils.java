package com.codice.notifier.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Android Preferences wrapper.
 *
 * @authot Sergio Luis Para
 */
public class PreferencesUtils {

    private static final String TAG = PreferencesUtils.class.toString();

    private static final String GCM_TOKEN = "token";
    private static final String GCM_ID = "id";
    private static final String HAS_GCM_TOKEN = "has_token";
    private static final String HAS_GCM_ID = "has_id";


    public static String getGcmId(Context context) {
        SharedPreferences defaultPrefs = getDefaultPreferences(context);
        String id = defaultPrefs.getString(GCM_ID, "");
        Log.d(TAG, "Returning GCM ID: " + id);
        return id;
    }

    public static void saveGcmId(Context context, String id) {
        Log.d(TAG, "Storing GCM ID: " + id);
        SharedPreferences.Editor defaultEditor = getDefaultEditor(context);
        defaultEditor.putString(GCM_ID, id);
        defaultEditor.apply();
        setHasGcmId(context, true);
    }

    public static boolean hasGcmId(Context context) {
        SharedPreferences defaultPrefs = getDefaultPreferences(context);
        boolean hasGCMId = defaultPrefs.getBoolean(HAS_GCM_ID, false);
        Log.d(TAG, "Returning has GCM ID: " + hasGCMId);
        return  hasGCMId;
    }

    public static void setHasGcmId(Context context, boolean hasGCMId) {
        Log.d(TAG, "Storing has GCM ID: " + hasGCMId);
        SharedPreferences.Editor defaultEditor = getDefaultEditor(context);
        defaultEditor.putBoolean(HAS_GCM_ID, hasGCMId);
        defaultEditor.apply();
    }

    private static SharedPreferences getDefaultPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static SharedPreferences.Editor getDefaultEditor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit();
    }
}
