package com.adamhalamus.mobilewallet.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class LoggingValues {
	public final static int LOGGING_VALID = 0;
	public final static int LOGGING_INVALID = 1;
	public final static int REGISTRATION = 2;
	
	public static boolean getSharedPreferencesValue(String key, Context context){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		
		return prefs.getBoolean(key, false);
	}
	
	public static void setSharedPreferencesBoolValue(String key, boolean value, Context context){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = prefs.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
}
