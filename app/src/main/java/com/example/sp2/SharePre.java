package com.example.sp2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePre {
    private static SharedPreferences sharedPreferences;
    public static final String spName="sharePreName";

    public static void init(Context context){
        if (sharedPreferences==null){
            sharedPreferences=context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        }
    }
    public static void Write(String key,String value){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public static String Read(String key,String defValue){
        return sharedPreferences.getString(key,defValue);
    }
}
