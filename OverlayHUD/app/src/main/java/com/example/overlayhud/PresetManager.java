package com.example.overlayhud;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
public class PresetManager {
    private static final String SP="overlay_presets_v1";
    public static void save(Context c, Preset p){
        SharedPreferences sp = c.getSharedPreferences(SP, Context.MODE_PRIVATE);
        sp.edit().putString(p.name, p.toJson().toString()).apply();
    }
    public static Preset load(Context c, String name){
        SharedPreferences sp = c.getSharedPreferences(SP, Context.MODE_PRIVATE);
        String s = sp.getString(name, null);
        if (s==null) return new Preset();
        try { return Preset.fromJson(new JSONObject(s)); } catch (JSONException e){ return new Preset(); }
    }
}

